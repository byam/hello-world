package hello

import (
	"fmt"
	"testing"
)

func makeSlice1(n int) []string {
	var r []string
	for i := 0; i < n; i++ {
		r = append(r, fmt.Sprintf("%03d hello", i))
	}
	return r
}

func makeSlice2(n int) []string {
	r := make([]string, n)
	for i := 0; i < n; i++ {
		r[i] = fmt.Sprintf("%03d hello", i)
	}
	return r
}

func BenchMarkSlice1(b *testing.B) {
	b.ResetTimer()
	makeSlice1(b.N)
}

func BenchMarkSlice2(b *testing.B) {
	b.ResetTimer()
	makeSlice2(b.N)
}
