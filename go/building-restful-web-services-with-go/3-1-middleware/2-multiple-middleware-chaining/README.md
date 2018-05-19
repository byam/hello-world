
## Build & run

* Start server
```bash
go run multipleMiddleware.go
```

* Client
```bash
curl -i -H "Content-Type: application/json" -X POST http://localhost:8000/city -d '{"name":"Boston", "area":89}'
HTTP/1.1 200 OK
Date: Sat, 19 May 2018 04:23:36 GMT
Content-Length: 13
Content-Type: text/plain; charset=utf-8

201 - Created

# console output
2018/05/19 13:23:36 Currently in the check content type middleware
2018/05/19 13:23:36 Got Boston city with area of 89 sq miles!
2018/05/19 13:23:36 Currently in the set server time middleware
```

```bash
curl -i -X POST http://localhost:8000/city -d '{"name":"New York", "area":304}' 
HTTP/1.1 415 Unsupported Media Type
Date: Sat, 19 May 2018 04:26:07 GMT
Content-Length: 46
Content-Type: text/plain; charset=utf-8

415 - Unsupported Media Type. Please send JSON%   

# console output
2018/05/19 13:26:07 Currently in the check content type middleware
```
