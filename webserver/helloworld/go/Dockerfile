FROM golang:1.8-alpine

COPY xmas /go/src/xmas
RUN go install xmas

FROM alpine:latest
COPY --from=0 /go/bin/xmas .

EXPOSE 8080

CMD ./xmas
