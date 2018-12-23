FROM golang:1.8-alpine

# compile and install packages and dependencies
COPY xmas /go/src/xmas
RUN go install xmas

## run binary
FROM alpine:latest
COPY --from=0 /go/bin/xmas .

EXPOSE 8080

CMD ./xmas
