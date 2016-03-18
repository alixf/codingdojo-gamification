var express = require('express');
var ws = require('nodejs-websocket');
var _ = require('lodash');
var bodyParser = require('body-parser');

var app = express();
app.use(express.static('.'));
app.use(bodyParser.json());       // to support JSON-encoded bodies
app.use(bodyParser.urlencoded({     // to support URL-encoded bodies
  extended: true
}));

app.get('/post', function(req, res) {
	clients.forEach(function(client) {
		var message = {
			type : 'achievement',
			user : req.query.user,
			id : req.query.id,
			success : req.query.success
		};
		console.log(message);
		client.send(JSON.stringify(message));
	});
	res.send('OK');
});

app.post('/code', function(req, res) {
	clients.forEach(function(client) {
		console.log(req.body);
		var message = {
			type : 'code',
			user : req.body.user,
			code : req.body.code
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
