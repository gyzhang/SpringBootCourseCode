var stompClient = null;
function connect() {
	var socket = new SockJS('/chat');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		stompClient.subscribe('/user/queue/chat', function(chat) {
			showChatMsg(JSON.parse(chat.body));
		});
	});
}

function sendMsg() {
	stompClient.send("/app/chat", {}, JSON.stringify({
		'to' : $("#to").val(),
		'content' : $("#content").val()
	}));
}

function showChatMsg(message) {
	$("#chatsContent")
	.append("<div>" + message.from + ": " + message.content + " [" + message.time + "] </div>");
}

$(function() {
	connect();
	$("#send").click(function() {
		sendMsg();
	});
});