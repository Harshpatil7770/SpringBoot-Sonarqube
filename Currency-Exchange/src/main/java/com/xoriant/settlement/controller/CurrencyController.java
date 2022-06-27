package com.xoriant.settlement.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.settlement.dto.CurrencyExchangeDTO;
import com.xoriant.settlement.model.CurrencyExchange;
import com.xoriant.settlement.msg.MessageSender;
import com.xoriant.settlement.service.CurrencyExchangeService;

@RestController
@RequestMapping("/api/currency-exchange")
@CrossOrigin
@RefreshScope
public class CurrencyController {

	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@Autowired
	MessageSender messageSender;

	@PostMapping("/save")
	public String addNewCurrencyExchangeDetails(@RequestBody CurrencyExchangeDTO currencyExchangeDTO) {
		String result = currencyExchangeService.addNewCurrencyExchangeDatails(currencyExchangeDTO);
		if (result != null) {

			String msg = "New Currency Exchange Deatails Added !!!  From " + currencyExchangeDTO.getFrom() + "\n "
					+ " To:: " + currencyExchangeDTO.getTo();
			messageSender.sendNewCurrencyExchangeDatails(msg);
		}
		return result;
	}

	@PutMapping("/update")
	public String updateCurrencyExchangeDetails(@Valid @RequestBody CurrencyExchangeDTO currencyExchangeDTO) {
		String result = currencyExchangeService.updateCurrencyExchangeDetails(currencyExchangeDTO);
		if (result != null) {
			messageSender.updateExistingCurrencyExchangeDetails(result);
		}
		return result;
	}

	@PostMapping("/saveAll")
	public List<CurrencyExchange> addNewListsOfCurrencyExchangeDetails(
			@RequestBody List<CurrencyExchange> currencyExchangeLists) {
		List<CurrencyExchange> listscurrencyExchange = currencyExchangeService
				.addNewListsOfCurrencyExchangeDetails(currencyExchangeLists);
		String result = "New Lists Of Currency Exchange Details Added Succesfully !";
		messageSender.addNewListOfCurrencyExchangeDetails(result);
		return listscurrencyExchange;
	}

	@PutMapping("/updateAll")
	public String updateListOfCurrencyExchangeDetails(@RequestBody List<CurrencyExchange> currencyExchangeLists) {
		String result = currencyExchangeService.updateListOfCurrencyExchangeDetails(currencyExchangeLists);
		if (result != null) {
			messageSender.updateListsOfCurrencyExchangeDetails(result);
		}
		return result;
	}

	@DeleteMapping("/find/{id}")
	public void deleteCurrecyExchangeDetails(@PathVariable int id) {
		currencyExchangeService.deleteCurrecyExchangeDetails(id);
		String result = "Deleted Currency Exchange Details succesfully !";
		messageSender.deleteCurrencyExchangeDetails(result);
	}

	@GetMapping("/fetchAll")
	public List<CurrencyExchange> fetchAllListsOfCurrencyDetails() {
		return currencyExchangeService.fetchAllListsOfCurrencyDetails();
	}

	@GetMapping("/find/{from}/{to}")
	public List<CurrencyExchange> fetchBasedOnCountryNames(@PathVariable String from, @PathVariable String to) {
		return currencyExchangeService.fetchBasedOnCountryNames(from, to);
	}

	@GetMapping("/find/{id}")
	public Optional<CurrencyExchange> fetchCurrencyExchangeDetailsBasedOnId(@PathVariable int id) {
		return currencyExchangeService.fetchCurrencyExchangeDetailsBasedOnId(id);
	}
}
