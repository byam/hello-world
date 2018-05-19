
## Install
```bash
go get github.com/justinas/alice
```

## Build & run

* Start server
```bash
go run aliceMiddleware.go
```

* Client
```bash
curl -i -H "Content-Type: application/json" -X POST http://localhost:8000/city -d '{"name":"Boston", "area":89}'
HTTP/1.1 200 OK
Date: Sat, 19 May 2018 04:30:14 GMT
Content-Length: 13
Content-Type: text/plain; charset=utf-8

201 - Created%

# console output
2018/05/19 13:30:14 Currently in the check content type middleware
2018/05/19 13:30:14 Got Boston city with area of 89 sq miles!
2018/05/19 13:30:14 Currently in the set server time middleware
```

