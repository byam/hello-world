package main

import (
	"log"
	"net/http"

	"github.com/gorilla/context"
)

var (
	validUser     = "test"
	validPassword = "abc123"
)

func Auth(next http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
			user := r.FormValue("user")
			if user == "" {
				http.Error(w, "MISSING_ARG_USER", 400)
				return
			}

			if user != validUser {
				http.Error(w, "NOT_AUTHORIZED", 403)
				return
			}

			password := r.FormValue("password")
			if password == "" {
				http.Error(w, "MISSING_ARG_PASSWORD", 400)
				return
			}

			if password != validPassword {
				http.Error(w, "NOT_AUTHORIZED", 403)
				return
			}

			context.Set(r, "user", user)

			next.ServeHTTP(w, r)
		})
}

func ping(w http.ResponseWriter, r *http.Request) {
	user, ok := context.GetOk(r, "user")
	if !ok {
		http.Error(w, "INTERNAL_ERROR", 500)
	}
	log.Printf("current user: %s", user)

	w.Write([]byte("OK\n"))
}

func main() {
	http.Handle("/ping", Auth(http.HandlerFunc(ping)))

	log.Println("listening on 8080")
	log.Fatal(http.ListenAndServe(":8080", nil))

}
