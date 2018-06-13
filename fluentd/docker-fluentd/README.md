## Resource

- https://github.com/Docker-example/alpine-fluentd
- https://docs.fluentd.org/v1.0/articles/life-of-a-fluentd-event

## Deploy

* Build docker image
```bash
docker build -t byam/alpine-fluentd .
```

* Run container
```
docker run -p 8888:8888 byam/alpine-fluentd
```

* New terminal (for client side)
```bash
curl -i -X POST -d 'json={"action":"login","user":2}' http://localhost:8888/test.cycle
```

* For `Filter` example
```bash
# accepted event
curl -i -X POST -d 'json={"action":"login","user":2}' http://localhost:8888/test.cycle

# rejected event
curl -i -X POST -d 'json={"action":"logout","user":2}' http://localhost:8888/test.cycle
```
