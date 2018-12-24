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
