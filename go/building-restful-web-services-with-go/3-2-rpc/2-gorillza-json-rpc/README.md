## Install
```bash
go get github.com/gorilla/rpc
```

## Build & run

* Run server
```bash
go run jsonRPCServer.go
```

* Run client
```bash
curl -X POST \
   http://localhost:1234/rpc \
   -H 'cache-control: no-cache' \
   -H 'content-type: application/json' \
   -d '{"method": "JSONServer.GiveBookDetail", "params": [{"Id": "1234"}],"id": "1"}'

{"result":{"Id":"1234","Name":"In the sunburned country","Author":"Bill Bryson"},"error":null,"id":"1"}
```
