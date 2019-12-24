package com.example.activemq.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {
	
	@JmsListener(destination = "Q1")
	public void msgReceive(String msg) {
		System.out.println("Message: " + msg + " Received.");
	}

}
