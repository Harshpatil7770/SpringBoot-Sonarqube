package com.cls.ccurrencyonversion.msgsender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class MessageSender {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Bean // Bean produced by bean and managed by spring container
	public Queue addNewCurrencyConversionDetails() {
		return new Queue("currency-conversion-added-Q", false);
	}

	public void addNewCurrencyConversionDetails(String msg) {
		rabbitTemplate.convertAndSend("currency-conversion-added-Q", msg);
	}
}
