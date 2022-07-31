package com.lta.springrabbitmq.publisher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lta.springrabbitmq.commons.message.OrderMessage;

@SpringBootApplication
public class SpringRabbitmqPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqPublisherApplication.class, args);
	}
	
	@Autowired
	private RabbitTemplate template;
	
	@Bean
	Queue queue() {
		return new Queue("incoming-orders");
	}
	
	@Bean
	CommandLineRunner sender() {
		
		return args -> {
			
			String message = "New order...";
			
			OrderMessage order = new OrderMessage();
			order.setCustomerName("my customer name");
			order.setCustomerAddress("my customer address");
			order.setNotes("notes...");
			
			List<Integer> productsIds = new ArrayList<Integer>();
			productsIds.add(10);
			productsIds.add(23);
			productsIds.add(32);
			productsIds.add(67);
			
			order.setProductsIds(productsIds);
			
			this.template.convertAndSend(queue().getName(), order);
			
			System.out.println("Message sent");
		};
	}
	
}
