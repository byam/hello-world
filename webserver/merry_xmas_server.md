# Merry Christmas サーバー

みなさんは新しい言語を習得していく時の最初の一歩はHello Worldではないでしょうか？
この記事ではいくつかのプログラミング言語でHello Worldの次の段階、Hello Worldウェッブサーバーを簡単に作って行きたいと思います。
また、ローカルマシンではそれぞれの言語をインストールのはめんどくさいと思うので、Docker Imageを使ってcontainer上で実行します。
あ、本日は12月25日Christmas Dayということで、Hello Worldの代わりにMerry Christmas!というメッセージを表示するようにしました。

これからウェッブサーバー作ろうと思っている人は以下を参考に描きやすさとか比べてみてくださいね。

- [x] go
- [x] python
- [x] java
- [ ] node
- [ ] ruby

* Docker build & run
```bash
CONTAINER_IMAGE=server-xmas

docker build --tag ${CONTAINER_IMAGE}:latest .

docker run --rm -p 8080:8080 ${CONTAINER_IMAGE}:latest
```

## Go

#### ウェブサーバー
```go
package main

import (
	"fmt"
	"log"
	"net/http"
)

var greeting  = "Merry Christmas!"

func handler(w http.ResponseWriter, r *http.Request) {
fmt.Fprint(w, greeting)
}

func main() {
	http.HandleFunc("/", handler)
	log.Fatal(http.ListenAndServe(":8080", nil))
}
```

#### Dockerfile
```dockerfile
FROM golang:1.8-alpine

# compile and install packages and dependencies
COPY xmas /go/src/xmas
RUN go install xmas

## run binary
FROM alpine:latest
COPY --from=0 /go/bin/xmas .

EXPOSE 8080

CMD ./xmas
```

#### 参考
- https://golang.org/doc/articles/wiki/#tmp_3 

## Python

以下はpython3の実装です。

* ウェブサーバー
```python
import http.server
import socketserver

GREETING = "Merry Christmas!"

class Handler(http.server.SimpleHTTPRequestHandler):
	def do_GET(self):
		self.send_response(200)
		self.end_headers()
		self.wfile.write(bytes(GREETING, "utf-8"))

with socketserver.TCPServer(("", 8080), Handler) as httpd:
	print("Server Running...")
	httpd.serve_forever()
```

* Dockerfile
```dockerfile
FROM python:3.7-alpine

COPY main.py /work/main.py

WORKDIR /work

EXPOSE 8080

CMD python /work/main.py
```

#### 参考
- https://docs.python.org/ja/3.7/library/http.server.html#module-http.server 

## Java

* ウェブサーバー
```java

```

* Dockerfile
```dockerfile

```

## NodeJs

* ウェブサーバー
```javascript

```

* Dockerfile
```dockerfile

```

## Ruby

* ウェブサーバー
```ruby

```

* Dockerfile
```dockerfile

```
