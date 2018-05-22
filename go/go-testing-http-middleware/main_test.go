package main

import (
	"net/http"
	"github.com/stretchr/testify/assert"
	"net/http/httptest"
	"io/ioutil"
	"testing"
	"bytes"
)

// GetTestHandler returns a http.HandlerFunc for testing http middleware
func GetTestHandler() http.HandlerFunc {
	fn := func(rw http.ResponseWriter, req *http.Request) {
		panic("test entered test handler, this should not happen")
	}
	return http.HandlerFunc(fn)
}

func TestAuth(t *testing.T) {
	assertions := assert.New(t)

	tests := []struct {
		description  string
		url          string
		expectedBody string
		expectedCode int
	}{
		{
			description:  "missing arg user",
			url:          "/ping",
			expectedBody: "MISSING_ARG_USER\n",
			expectedCode: 400,
		}, {
			description:  "bad user",
			url:          "/ping?user=baduser",
			expectedBody: "NOT_AUTHORIZED\n",
			expectedCode: 403,
		}, {
			description:  "missing arg password",
			url:          "/ping?user=test",
			expectedBody: "MISSING_ARG_PASSWORD\n",
			expectedCode: 400,
		}, {
			description:  "bad password",
			url:          "/ping?user=test&password=badpassword",
			expectedBody: "NOT_AUTHORIZED\n",
			expectedCode: 403,
		},
	}

	ts := httptest.NewServer(Auth(GetTestHandler()))
	defer ts.Close()

	for _, tc := range tests {
		var u bytes.Buffer
		u.WriteString(string(ts.URL))
		u.WriteString(tc.url)

		res, err := http.Get(u.String())
		assertions.NoError(err)
		if res != nil {
			defer res.Body.Close()
		}

		b, err := ioutil.ReadAll(res.Body)
		assertions.NoError(err)

		assertions.Equal(tc.expectedCode, res.StatusCode, tc.description)
		assertions.Equal(tc.expectedBody, string(b), tc.description)
	}
}
