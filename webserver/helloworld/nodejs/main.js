const http = require('http');

const port = 8080;

const server = http.createServer((req, res) => {
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/plain');
    res.end('Merry Christmas! (nodejs)\n');
});

server.listen(port, () => {
    console.log(`Server running at http://localhost:${port}/`);
});
