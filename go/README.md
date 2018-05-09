## Install

1. Download file https://golang.org/dl/
2. Set `GOPATH` to `.bashrc` file
    ```bash
    # Go
    export PATH="/usr/local/go/bin:$PATH"
    export GOPATH=$(go env GOPATH)
    ```
3. Check `go`
    ```bash
    source .bashrc
    go version
    go version go1.10.1 darwin/amd64
    ```

## Useful commands

* `run`
If there is only `*.go` file
```bash
go run FILE_NAME.go
```

* `build`
Build folder's all `*.go` files to binary
```bash
go build -o BINARY_FILE_NAME
./BINARY_FILE_NAME
```

> exclude `*_test.go` files

* `get`
Downloads the packages.
```bash
go get PACKAGE_NAME
```

* `test -cover`
show test coverage
```bash
go test -cover
```

## Go idioms

### `defer`
* defers the execution of a function until the surrounding function returns.

```go
package main

import "fmt"

func main() {
	defer fmt.Println("world")

	fmt.Println("hello")
}
```

Output:
```bash
hello
world
```


### `select`
* 共有されているメモリに対して同期化や変更がいくつか必要な任意の箇所で、このselect文を利用する。
チャネルに送信された値に応じて、異なる操作を行うということも可能です。
* select文のcase節のコードは、同時に実行することはありません。

```go
type room struct {
	// forwardは他のクライアントに転送するためのメッセージが保持するチャネル
	forward chan []byte

	// joinはチャットルームに参加しようとしているクライアントのチャネル
	join chan *client

	// leaveはチャットルームから退室しようとしているクライアントチャネル
	leave chan *client

	// clientsには在室している全てのクライアントが保持されます
	clients map[*client]bool
}

func (r *room) run() {
	for {
		select {
		case client := <-r.join:
			// 参加
			r.clients[client] = true
		case client := <-r.leave:
			// 退室
			delete(r.clients, client)
			close(client.send)
		case msg := <-r.forward:
			// 全てのクライアントにメッセージを転送
			for client := range r.clients {
				select {
				case client.send <- msg:
					// メッセージを送信
				default:
					// 送信に失敗
					delete(r.clients, client)
					close(client.send)
				}
			}
		}
	}
}
```

### `go`
* `goroutine` として実行される。メソッドに別のスレッドが割り当たれる

```go
package main

import (
	"fmt"
	"time"
)

func say(s string) {
	for i := 0; i < 5; i++ {
		time.Sleep(100 * time.Millisecond)
		fmt.Println(s)
	}
}

func main() {
	go say("world")
	say("hello")
}
```

Output:
```bash
world
hello
hello
world
world
hello
hello
world
world
hello
```
