## Build & Deploy

### Prepare

* Database
```bash
docker run -d --name kong-database \
              -p 5432:5432 \
              -e "POSTGRES_USER=kong" \
              -e "POSTGRES_DB=kong" \
              postgres:9.4
docker run --rm \
    --link kong-database:kong-database \
    -e "KONG_DATABASE=postgres" \
    -e "KONG_PG_HOST=kong-database" \
    kong:latest kong migrations up
```

* Go app
```bash
# build image
docker build . -t gobuild

# run container
docker run  -p 3000:3000 --name go-server -dit gobuild
```

* Kong
````bash
docker run -d --name kong \
    --link kong-database:kong-database \
    --link go-server:go-server \
    -e "KONG_DATABASE=postgres" \
    -e "KONG_PG_HOST=kong-database" \
    -e "KONG_PROXY_ACCESS_LOG=/dev/stdout" \
    -e "KONG_ADMIN_ACCESS_LOG=/dev/stdout" \
    -e "KONG_PROXY_ERROR_LOG=/dev/stderr" \
    -e "KONG_ADMIN_ERROR_LOG=/dev/stderr" \
    -p 8000:8000 \
    -p 8443:8443 \
    -p 8001:8001 \
    -p 8444:8444 \
    kong:latest
````

### Client
```bash
curl -X GET http://localhost:8001/status
```