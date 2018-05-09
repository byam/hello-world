package chat

import (
	"github.com/gorilla/websocket"
)

// clientはチャットを行っている1人のユーザを表します。
type client struct{
	// socketはこのクライアントのためWebSocketです。
	socket *websocket.Conn

	// sendはメッセージが遅れるチャネル
	send chan []byte

	// roomはこのクライアントが参加しているチャットルーム
	room *room
}

func (c *client) read() {
	for {
		if _, msg, err := c.socket.ReadMessage(); err == nil {
			c.room.forward <- msg
		} else {
			break
		}
	}
	c.socket.Close()
}

func (c *client) write()  {
	for msg := range c.send {
		if err := c.socket.WriteMessage(websocket.TextMessage, msg); err != nil {
			break
		}
	}
	c.socket.Close()
}

func newRoom() *room{
	return &room{
		forward: make(chan []byte),
		join:    make(chan *client),
		leave:   make(chan *client),
		clients: make(map[*client]bool),
	}
}
