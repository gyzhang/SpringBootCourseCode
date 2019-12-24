package com.example.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String msg) {
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("KafkaTopic", msg);
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onFailure(Throwable throwable) {
				System.out.println("Send Message Failure:" + throwable.getMessage());
			}

			@Override
			public void onSuccess(SendResult<String, String> sendResult) {
				System.out.println("Send Message Success:" + sendResult.toString());
			}
		});
	}

}
