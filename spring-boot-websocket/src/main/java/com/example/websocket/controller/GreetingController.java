package com.example.websocket.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.websocket.vo.Message;

@Controller
public class GreetingController {
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Message greeting(Message message) throws Exception {
		Calendar calendar = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = calendar.getTime();
		
		message.setTime(df.format(date));//添加发送时间
		
		return message;
	}

}
