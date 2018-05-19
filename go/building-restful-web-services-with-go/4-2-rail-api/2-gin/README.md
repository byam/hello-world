# Gin

- Use the Gin framework if you are quickly prototyping a REST web service. 
- You can also use it for many other things such as static file serving and so on. 
- Remember that it is a fully-fledged web framework. 
- For fetching the query parameters in Gin, use the following method on the Gin context object: c.Query("param").

## Install
```bash
go get gopkg.in/gin-gonic/gin.v1
```

## Build & run

* Run server
```bash
go run main.go
```

* Post 

```bash
curl -X POST \
  http://localhost:8000/v1/stations \
 -H 'cache-control: no-cache' \
 -H 'content-type: application/json' \
 -d '{"name":"Brooklyn", "opening_time":"8:12:00", "closing_time":"18:23:00"}'
 
 {"result":{"id":1,"name":"Brooklyn","opening_time":"8:12:00","closing_time":"18:23:00"}}%
```

* GET
```bash
CURL -X GET "http://localhost:8000/v1/stations/1"
{"result":{"id":1,"name":"Brooklyn","opening_time":"8:12:00","closing_time":"18:23:00"}}%
```

* DELETE
```bash
CURL -X DELETE "http://localhost:8000/v1/stations/1"
```

## go-restful

- go-restful is a lightweight library that is powerful in creating RESTful services in an elegant way. 
- The main theme is to convert resources (models) into consumable APIs. 
- Using other heavy frameworks may speed up the development, but the API can end up slower because of the wrapping of code. 
- go-restful is a lean and low-level package for API creation.
- go-restful also provides built-in support for documenting the REST API with swagger. [go-restful-swagger12](https://github.com/emicklei/go-restful-swagger12)
