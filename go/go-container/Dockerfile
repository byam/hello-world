FROM golang:1.8-alpine

ADD . /go/src/simple-web-app
RUN go install simple-web-app

FROM alpine:latest

COPY --from=0 /go/bin/simple-web-app .
ENV PORT 8080
CMD ["./simple-web-app"]
