package com.example.rabbitmq.producer;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducerAck implements RabbitTemplate.ReturnCallback {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void returnedMessage(Message message, int i, String s, String s1, String s2) {
		System.out.println("RabbitMQProducerAck Returned Message: " + message.toString() + " , " + i + " , " + s1 + " , " + s2);
	}

	public void sendMessage(String msg) {
		rabbitTemplate.setReturnCallback(this);
		rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
			if (ack) {
				System.out.println("Send Message Success.");
			} else {
				System.out.println("Send Message Failure:" + cause + correlationData.toString());
			}
		});
		rabbitTemplate.convertAndSend("lily", msg + ", " + LocalDateTime.now(ZoneId.systemDefault()));
	}
	
}