package chat

import (
	"log"
	"net/http"
	"text/template"
	"path/filepath"
	"sync"
	"flag"
)

// temp1は1つのテンプレートを表します
type templateHandler struct {
	once 		sync.Once
	filename 	string
	temp1 		*template.Template
}

// ServeHTTPはHTTPリクエストを処理します
func (t *templateHandler) ServeHTTP(w http.ResponseWriter, r *http.Request) {
	t.once.Do(func() {
		t.temp1 = template.Must(template.ParseFiles(filepath.Join("templates", t.filename)))
	})
	t.temp1.Execute(w, r)
}

func main()  {

	var addr = flag.String("addr", ":8080", "アプリケーションアドレス")
	flag.Parse() // プラグを解釈する

	r := newRoom()

	// ルート
	http.Handle("/", &templateHandler{filename: "chat.html"})

	// ルーム
	http.Handle("/room", r)
	// チャットルーム開始する
	go r.run()

	// Webサーバを開始します
	log.Println("Webサーバを開始する。ポート： ", *addr)
	if err := http.ListenAndServe(*addr, nil); err != nil {
		log.Fatal("ListenAndServe:", err)
	}
}
