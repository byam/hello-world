FROM golang

ADD kongExample /go/src/kongExample
RUN go get github.com/gorilla/mux
RUN go install kongExample
ENTRYPOINT /go/bin/kongExample
