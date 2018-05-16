FROM golang:1.8-alpine

# compile and install packages and dependencies
ADD . /go/src/simple-web-app
RUN go install simple-web-app

# run binary
FROM alpine:latest
COPY --from=0 /go/bin/simple-web-app .
ENV PORT 8080
CMD ["./simple-web-app"]
