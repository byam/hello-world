## Deploy

```bash
docker build -t byam/alpine-fluentd .

docker run -it byam/alpine-fluentd /bin/sh
fluentd -c /etc/fluentd/in_docker.conf
cat /var/log/fluentd/out_file_test
```
