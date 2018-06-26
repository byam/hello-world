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

# Installing Fluentd + plugins
RUN echo 'gem: --no-document' >> /etc/gemrc && \
        gem install oj && \
        gem install json && \
        gem install fluentd -v ${FLUENTD_VERSION} && \
        gem install fluent-plugin-record-reformer -v 0.8.3 && \
        apk del .build-deps

# Coping config
COPY ./files/in_http_out_stdout.conf /etc/fluentd/in_http_out_stdout.conf

EXPOSE 8888

CMD [ "fluentd", "-c", "/etc/fluentd/in_http_out_stdout.conf"]
