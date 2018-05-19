## Build & run

* Start server
```bash
go run queryParameters.go
```

* Client
```bash
curl -X GET http://localhost:8000/articles\?id\=1345\&category\=birds
Got parameter id:1345!
Got parameter category:birds!%
```
