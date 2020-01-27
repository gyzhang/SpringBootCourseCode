package com.example.websocket.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.websocket.vo.ChatMsg;

@Controller
public class ChatController {
	@Autowired
	SimpMessagingTemplate template;
	
	@MessageMapping("/chat")
    public void chat(Principal principal, ChatMsg msg) throws Exception {
        String from=principal.getName();
        msg.setFrom(from);
        
		Calendar calendar = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = calendar.getTime();
		
		msg.setTime(df.format(date));//添加发送时间

        template.convertAndSendToUser(msg.getTo(), "/queue/chat", msg);;
    }

}
