package hello

import (
	"fmt"
	"time"
)

func printHello() {
	fmt.Println("Hello")
}

func printWorld() {
	fmt.Println("World")
}

func main() {
	printHello()
	printWorld()
	time.Sleep(time.Second)
}
