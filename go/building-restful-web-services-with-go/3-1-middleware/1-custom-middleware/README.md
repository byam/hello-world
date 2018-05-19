
## Build & run

* Start server
```bash
go run customMiddleware.go
```

* Client
```bash
curl -X GET http://localhost:8000

# console
Executing middleware before request phase!
Executing mainHandler...
Executing middleware after response phase!
```

