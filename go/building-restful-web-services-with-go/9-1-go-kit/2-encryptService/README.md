## Build & run

* Run server
```bash
go run main.go
```

* Client
```bash
curl -XPOST -d '{"key":"111023043350789514532147", "text": "I am A Message"}' http://localhost:8080/encrypt
{"message":"8/+JCfTb+ibIjzQtmCo=","error":""}
```
