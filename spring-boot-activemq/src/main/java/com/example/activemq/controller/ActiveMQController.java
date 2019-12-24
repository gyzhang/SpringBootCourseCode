package com.example.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activemq/")
public class ActiveMQController {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@RequestMapping("/send")
	public String sendMsg(String msg) {
		jmsTemplate.convertAndSend("Q1", msg);
		return msg + " Sended to Q1.";
	}

}
