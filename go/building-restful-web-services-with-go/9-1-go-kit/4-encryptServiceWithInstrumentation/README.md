## Install
```bash
go get github.com/prometheus/client_golang/prometheus
go get github.com/prometheus/client_golang/prometheus/promhttp
```

## Build & run

* Run server
```bash
go run main.go
```

* Client
```bash
# encrypt x 5
for i in 1 2 3 4 5; do curl -XPOST -d'{"key":"111023043350789514532147", "text": "I am A Message"}' localhost:8080/encrypt; done
{"message":"8/+JCfTb+ibIjzQtmCo=","error":""}
{"message":"8/+JCfTb+ibIjzQtmCo=","error":""}
{"message":"8/+JCfTb+ibIjzQtmCo=","error":""}
{"message":"8/+JCfTb+ibIjzQtmCo=","error":""}
{"message":"8/+JCfTb+ibIjzQtmCo=","error":""}

# decrypt x 10
for i in 1 2 3 4 5 6 7 8 9 10; do curl -XPOST -d'{"key":"111023043350789514532147", "message": "8/+JCfTb+ibIjzQtmCo="}' localhost:8080/decrypt; done
{"text":"I am A Message","error":""}
{"text":"I am A Message","error":""}
{"text":"I am A Message","error":""}
{"text":"I am A Message","error":""}
{"text":"I am A Message","error":""}
{"text":"I am A Message","error":""}
{"text":"I am A Message","error":""}
{"text":"I am A Message","error":""}
{"text":"I am A Message","error":""}
{"text":"I am A Message","error":""}
```

* Console
```bash
method=encrypt key=111023043350789514532147 text="I am A Message" output="8/+JCfTb+ibIjzQtmCo=" err=null took=26.603µs
method=decrypt key=111023043350789514532147 message="8/+JCfTb+ibIjzQtmCo=" output="I am A Message" err=null took=13.856µs
```

