package com.xoriant.settlement.msg;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class MessageSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Bean
	public Queue addNewTransactionDetails() {
		return new Queue("CurrencyExchangeQ", false);
	}

	public void sendNewCurrencyExchangeDatails(String msg) {
		rabbitTemplate.convertAndSend("CurrencyExchangeQ", msg);
	}

	@Bean
	public Queue updateCurrencyExchange() {
		return new Queue("UpdateCurrencyExchangeQ", false);
	}

	public void updateExistingCurrencyExchangeDetails(String msg) {
		rabbitTemplate.convertAndSend("UpdateCurrencyExchangeQ", msg);
	}

	// @Bean is method level annotations method produced by bean and managed by
	@Bean // spring container
	public Queue addNewListsOfCurrencyExchangeDetails() {
		return new Queue("AddNewCurrencyExchangeListsQ", false);
	}

	public void addNewListOfCurrencyExchangeDetails(String msg) {
		rabbitTemplate.convertAndSend("AddNewCurrencyExchangeListsQ", msg);
	}

	@Bean
	public Queue updateListsofCurrencyExchangeDeatils() {
		return new Queue("updateListsOfCurrencyDetailsQ", false);
	}

	public void updateListsOfCurrencyExchangeDetails(String msg) {
		rabbitTemplate.convertAndSend("updateListsOfCurrencyDetailsQ", msg);
	}

	@Bean
	public Queue deleteCurrencyExchangeDetails() {
		return new Queue("deleteCurrencyExchangeQ", false);
	}

	public void deleteCurrencyExchangeDetails(String result) {
		rabbitTemplate.convertAndSend("deleteCurrencyExchangeQ", result);

	}
}
