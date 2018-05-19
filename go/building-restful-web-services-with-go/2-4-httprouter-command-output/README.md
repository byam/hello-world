## httprouter

`httprouter`, as the name suggests, routes the HTTP requests to particular handlers. Compared to the basic router, it has the following features:

- Allows variables in the route paths
- It matches the REST methods (GET, POST, PUT, and so on)
- No compromising on performance

## Install

```bash
go get github.com/julienschmidt/httprouter
```

## Build & run

* Start server
```bash
go run execService.go
```

* Client
```bash
curl -X GET http://localhost:8000/api/v1/go-version 
go version go1.10.1 darwin/amd64

curl -X GET http://localhost:8000/api/v1/show-file/helloworld.txt
Hello World!
```

