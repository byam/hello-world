# Merry Christmas ウェッブサーバー

この記事は[リクルートライフスタイル Advent Calendar 2018](https://qiita.com/advent-calendar/2018/recruitlifestyle)の25日目の記事です。

[CET](https://engineer.recruit-lifestyle.co.jp/techblog/2018-02-21-rls-meetup-7/)というチームの @bya です。

## はじめに

みなさんは新しい言語を習得していく時の最初の一歩は`Hello World`ではないでしょうか？ この記事で単なる`Hello World`を出力ではなく、`Hello World`ウェッブサーバーをいくつかのプログラミング言語で作って行きたいと思います。各言語のウェッブサーバーフレームワークを使用せずに、できるだけ標準ライブラリーを使用します。

あ、本日は12月25日Christmas Dayということで、`Hello World`の代わりに`Merry Christmas!`というメッセージを表示するようにしました。

また、ローカルマシンではそれぞれの言語をインストールのはめんどくさいと思うので、Docker Imageを使ってcontainer上で実行します。

Dockerfileとソースコードがあるディレクターで以下のコマンドを実行します。

```bash
docker build --tag server-xmas:latest . && docker run --rm -p 8080:8080 server-xmas:latest
```

プラウザで [localhost:8080](http://localhost:8080) に開くと、`Merry Christmas!` というメッセージが表示されます。

では、各言語の書きやすさなどを比べてみてくださいね。

みなさん、Merry Christmas!!!

## Go

以下のように、ソースコードとDockerfileを配置し、上記でのdockerコマンドを実行します。

```bash
├── Dockerfile
└── xmas
    └── main.go
```

#### ソースコード

`main.go`:

```go
package main

import (
"fmt"
"log"
"net/http"
)

var greeting  = "Merry Christmas! (go)"

func myHandler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprint(w, greeting)
}

func main() {
	http.HandleFunc("/", myHandler)
	log.Fatal(http.ListenAndServe(":8080", nil))
}
```

#### Dockerfile
```dockerfile
FROM golang:1.8-alpine

COPY xmas /go/src/xmas
RUN go install xmas

FROM alpine:latest
COPY --from=0 /go/bin/xmas .

EXPOSE 8080

CMD ./xmas
```

## Python

python3の実装です。以下のように、ソースコードとDockerfileを配置し、上記でのdockerコマンドを実行します。

```bash
.
├── Dockerfile
├── main.py
```

#### ソースコード
`main.py`:

```python
import http.server
import socketserver

GREETING = "Merry Christmas! (python3)"

class MyHandler(http.server.SimpleHTTPRequestHandler):
	def do_GET(self):
		self.send_response(200)
		self.end_headers()
		self.wfile.write(bytes(GREETING, "utf-8"))

with socketserver.TCPServer(("", 8080), MyHandler) as httpd:
	print("Server Running...")
	httpd.serve_forever()
```

#### Dockerfile
```dockerfile
FROM python:3.7-alpine

ENV DIR=/work

COPY main.py ${DIR}/main.py

WORKDIR ${DIR}

EXPOSE 8080

CMD python main.py
```

## Java

javaのウェッブサーバーと言えば、`Spring` を使うと思いますが、メッセージ表示するだけなので標準のライブラリーだけで作成します。

以下のように、ソースコードとDockerfileを配置し、上記でのdockerコマンドを実行します。

```bash
.
├── Dockerfile
├── main.java
```

#### ソースコード
`main.java`:

```java
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

class Main {
    static final String GREETING = "Merry Christmas! (java)";

    public static void main (String args[]) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
    }

    static class MyHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            System.out.println("Server running...");
            t.sendResponseHeaders(200, GREETING.length());
            OutputStream outputStream = t.getResponseBody();
            outputStream.write(GREETING.getBytes());
            outputStream.close();
        }
    }
}
```

#### Dockerfile
```dockerfile
FROM openjdk:8-jdk-alpine3.8

ENV DIR=/work

COPY main.java ${DIR}/main.java

WORKDIR ${DIR}

RUN javac main.java

EXPOSE 8080

CMD java Main
```

## NodeJs

なまのJavascriptでは書けないので、nodejsで書きます！

以下のように、ソースコードとDockerfileを配置し、上記でのdockerコマンドを実行します。

```bash
.
├── Dockerfile
├── main.js
```

#### ソースコード
`main.java`:

```javascript
const http = require('http');

const port = 8080;

const server = http.createServer((req, res) => {
    res.statusCode = 200;
res.setHeader('Content-Type', 'text/plain');
res.end('Merry Christmas! (nodejs)\n');
});

server.listen(port, () => {
    console.log(`Server running at http://localhost:${port}/`);
});
```

#### Dockerfile
```dockerfile
FROM node:8.14-alpine

ENV DIR=/work

COPY main.js ${DIR}/main.js

WORKDIR ${DIR}

EXPOSE 8080

CMD node main.js
```

##おわりに

上記を比べてみてどうでしょうか？　それぞれの良さがちょっとだけでも見えたら幸いです。

次の記事では各言語の主要となるフレームワークを使って、 `Hello World!` ウェッブサーバーも作って行こうと思います。

ソースコードも[Github](https://github.com/byam/hello-world/tree/master/webserver/helloworld)に上げています。

#### 参考
- https://golang.org/doc/articles/wiki/#tmp_3 
- https://docs.python.org/ja/3.7/library/http.server.html#module-http.server 
- https://nodejs.org/en/docs/guides/getting-started-guide/
