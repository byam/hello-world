## Build & run

* Run server
```bash
go run main.go
```

* Client
```bash
curl -XPOST -d'{"key":"111023043350789514532147", "text": "I am A Message"}' localhost:8080/encrypt
{"message":"8/+JCfTb+ibIjzQtmCo=","error":""}

curl -XPOST -d'{"key":"111023043350789514532147", "message": "8/+JCfTb+ibIjzQtmCo="}' localhost:8080/decrypt
{"text":"I am A Message","error":""}
```

* Console
```bash
method=encrypt key=111023043350789514532147 text="I am A Message" output="8/+JCfTb+ibIjzQtmCo=" err=null took=26.603µs
method=decrypt key=111023043350789514532147 message="8/+JCfTb+ibIjzQtmCo=" output="I am A Message" err=null took=13.856µs
```

