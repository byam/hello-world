FROM alpine:3.7

LABEL MAINTAINER="Byambasuren Ganbaatar <bya_ganbaatar@r.recruit.co.jp>"
LABEL APP="fluentd"
LABEL APP_VERSION="0.14.23"

ENV TIMEZONE Asia/Tokyo
ENV FLUENTD_VERSION 0.14.23

# Installing dependencies
RUN apk --update add --no-cache ruby ruby-irb su-exec
RUN apk --update add --no-cache --virtual .build-deps build-base ruby-dev

# Work path
WORKDIR /scripts

# Creating user Fluentd
RUN addgroup fluentd && \
        adduser -s /bin/false -G fluentd -S -D fluentd

# Installing Fluentd + plugins S3 & ES
RUN echo 'gem: --no-document' >> /etc/gemrc && \
        gem install oj && \
        gem install json && \
        gem install fluentd -v ${FLUENTD_VERSION} && \
        gem install fluent-plugin-s3 && \
        gem install fluent-plugin-elasticsearch && \
        gem install fluent-plugin-record-reformer && \
        apk del .build-deps

RUN echo "Hello Byam" > /var/log/fluentd_test.log
RUN mkdir /var/log/fluentd

# Coping config & scripts
COPY ./files/in_docker.conf /etc/fluentd/in_docker.conf
COPY ./scripts/start.sh start.sh
