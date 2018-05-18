#!/bin/sh

exec su-exec fluentd fluentd -c /etc/fluentd/in_docker.conf
