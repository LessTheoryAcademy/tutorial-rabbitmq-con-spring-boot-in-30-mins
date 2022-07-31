package com.lta.springrabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.lta.springrabbitmq.commons.message.OrderMessage;

@Component
public class MessageReceiver {

	@RabbitListener(queues = "incoming-orders")
	public void receive(OrderMessage message) {
		
		System.out.println("Received : " + message);
	}
}
