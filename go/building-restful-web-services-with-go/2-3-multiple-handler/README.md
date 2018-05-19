
## Build & run

* Start server
```bash
go run multipleHandlers.go
```

* Client
```bash
curl -X GET http://localhost:8000/randomInt
81

curl -X GET http://localhost:8000/randomFloat
0.9405090880450124
```

