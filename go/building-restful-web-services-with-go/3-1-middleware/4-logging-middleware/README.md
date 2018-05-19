
## Install
```bash
go get "github.com/gorilla/handlers"
```

## Build & run

* Start server
```bash
go run loggingMiddleware.go
```

* Client
```bash
curl -X GET http://127.0.0.1:8000/                                   
OK%                                

# console
127.0.0.1 - - [19/May/2018:13:33:56 +0900] "GET / HTTP/1.1" 200 2
2018/05/19 13:33:56 Processing request!
2018/05/19 13:33:56 Finished processing request
```
