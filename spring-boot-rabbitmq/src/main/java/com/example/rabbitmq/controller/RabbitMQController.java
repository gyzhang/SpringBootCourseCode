package com.example.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmq.producer.RabbitMQProducer;
import com.example.rabbitmq.producer.RabbitMQProducerAck;
import com.example.rabbitmq.producer.RabbitMQProducerMore;

@RestController
@RequestMapping("/rabbitmq/")
public class RabbitMQController {
	
	@Autowired
	RabbitMQProducer rabbitMQProducer;
	
	@RequestMapping("/send")
	public String sendMsg(String msg) {
		rabbitMQProducer.sendMessage(msg);
		return msg + " Sended to kevin.";
	}

	@Autowired
	RabbitMQProducerMore rabbitMQProducerMore;

	@RequestMapping("/sendMore")
	public String sendMoreMsg(String msg) {
		for (int i = 0; i < 5; i++) {
			rabbitMQProducerMore.sendMessage(msg + "No." + i);
		}
		return msg + " Sended 5 Messages to roy.";
	}

	@Autowired
	RabbitMQProducerAck rabbitMQProducerAck;
	
	@RequestMapping("/sendAck")
	public String sendAckMsg(String msg) {
		rabbitMQProducerAck.sendMessage(msg);
		return msg + " Sended to lily.";
	}
	
}
