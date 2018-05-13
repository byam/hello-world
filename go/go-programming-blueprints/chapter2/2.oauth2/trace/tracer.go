package trace

import (
	"io"
	"fmt"
)

// Tracerはコード内での出来事を記録できるオブジェクトを表すインタフェースです。
type Tracer interface {
	// 任意の型の引数を何個でも受け取る
	Trace(...interface{})
}

type tracer struct {
	out io.Writer
}

func (t *tracer) Trace(a ...interface{})  {
	t.out.Write([]byte(fmt.Sprint(a...)))
	t.out.Write([]byte("\n"))
}

func New(w io.Writer) Tracer {
	return &tracer{out: w}
}

type nilTracer struct{}

func (t *nilTracer) Trace(a ...interface{}) {}
// OffはTraceメソッドの呼び出しを無視するTracerを返します
func Off() Tracer {
	return &nilTracer{}
}
