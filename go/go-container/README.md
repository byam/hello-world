# Go Container

## Resource
- [Deploying a containerized web application](https://cloud.google.com/kubernetes-engine/docs/tutorials/hello-app)
- [Docker Image](https://hub.docker.com/_/golang/)


## Deploy

* Build image
```bash
docker build -t go-simple-web-app:v1 .
```

* Run
```bash
docker run --rm -p 8080:8080 go-simple-web-app:v1
```
