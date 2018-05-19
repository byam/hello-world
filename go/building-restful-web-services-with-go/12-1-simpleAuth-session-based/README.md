## Install
```bash
go get github.com/gorilla/sessions
```

## Build & Deploy

* Server
```bash
go run main.go
```

* Client
```bash
# healthcheck
curl -X GET \
  http://localhost:8000/healthcheck 
Forbidden

# login
curl -X POST \
  http://localhost:8000/login \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -d 'username=admin&password=password'
Logged In successfully

# logout
curl -X GET \
  http://localhost:8000/logout 

```
