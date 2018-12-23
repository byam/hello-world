import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

class Main {
    static final String GREETING = "Merry Christmas!";

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
