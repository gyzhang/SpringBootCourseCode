package com.example.activemq.topic.producer;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class TopicProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendMessage(String msg) {
		ActiveMQTopic destination = new ActiveMQTopic("Topic-Weather");
		jmsTemplate.convertAndSend(destination, msg);
	}

}
