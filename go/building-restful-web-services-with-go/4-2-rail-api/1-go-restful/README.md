## Build & run

* Run server
```bash
go run main.go
```

* Post 

```bash
curl -X POST \
  http://localhost:8000/v1/trains \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{"driverName": "Menaka", "operatingStatus": true}'
{
  "ID": 1,
  "DriverName": "Menaka",
  "OperatingStatus": true
 }%   
```

* GET
```bash
CURL -X GET "http://localhost:8000/v1/trains/1"
{
  "ID": 1,
  "DriverName": "Menaka",
  "OperatingStatus": true
 }% 
```

* DELETE
```bash
CURL -X DELETE "http://localhost:8000/v1/trains/1"
```

## go-restful

- go-restful is a lightweight library that is powerful in creating RESTful services in an elegant way. 
- The main theme is to convert resources (models) into consumable APIs. 
- Using other heavy frameworks may speed up the development, but the API can end up slower because of the wrapping of code. 
- go-restful is a lean and low-level package for API creation.
- go-restful also provides built-in support for documenting the REST API with swagger. [go-restful-swagger12](https://github.com/emicklei/go-restful-swagger12)
