var express = require('express');
var ws = require('nodejs-websocket');
var _ = require('lodash');

var app = express();
app.use(express.static('.'));

app.get('/post', function(req, res) {
	clients.forEach(function(client) {
		var message = {
			user : req.query.user,
			id : req.query.id
		};
		console.log(message);
		client.send(JSON.stringify(message));
	});
	res.send('OK');
});

app.listen(80);

var clients = [];
var server = ws.createServer(function (client) {
	clients.push(client);
	client.on('close', function (code, reason) {
		_.pull(clients, client);
	});
}).listen(8001);

console.log('OK');
