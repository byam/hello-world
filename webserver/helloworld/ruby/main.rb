require 'socket'

message = "Merry Christmas! (ruby)"

server = TCPServer.new 8080
loop do
  client = server.accept

  client.puts "HTTP/1.0 200 OK"
  client.puts "Content-Type: text/plain"
  client.puts
  client.puts message
  client.close
end
