package main

import (
	"log"
	"net/http"
)

func main()  {
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		w.Write([]byte(`
			<html>
				<head>
						<title>Go App</title>
				</head>
				<body>
						Simple Web App！
				</body>
			</html>
		`))
	})

	// Webサーバを開始します
	if err := http.ListenAndServe(":8080", nil); err != nil {
		log.Fatal("ListenAndServe:", err)
	}
}
