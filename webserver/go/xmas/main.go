package main

import (
"fmt"
"log"
"net/http"
)

var greeting  = "Merry Christmas!"

func myHandler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprint(w, greeting)
}

func main() {
	http.HandleFunc("/", myHandler)
	log.Fatal(http.ListenAndServe(":8080", nil))
}
