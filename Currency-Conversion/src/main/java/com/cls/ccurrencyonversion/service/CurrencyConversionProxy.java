package com.cls.ccurrencyonversion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cls.ccurrencyonversion.dto.CurrencyExchange;
import com.cls.ccurrencyonversion.dto.CurrencyExchangeDTO;

@FeignClient(name = "currency-exchange")
public interface CurrencyConversionProxy {

	@PostMapping("api/currency-exchange/save")
	public String addNewCurrencyExchangeDetails(@RequestBody CurrencyExchangeDTO currencyExchangeDTO);

	@GetMapping("/api/currency-exchange/find/{id}")
	Optional<CurrencyExchange> fetchCurrencyExchangeDetailsBasedOnId(@PathVariable int id);

	@PutMapping("/api/currency-exchange/updateAll")
	String updateListOfCurrencyExchangeDetails(@RequestBody List<CurrencyExchange> currencyExchangeLists);

	@DeleteMapping("api/currency-exchange/find/{id}")
	void deleteCurrecyExchangeDetails(@PathVariable int id);

	@GetMapping("api/currency-exchange/fetchAll")
	List<CurrencyExchange> fetchAllListsOfCurrencyDetails();

	@GetMapping("api/currency-exchange/find/exchange-details")
	List<CurrencyExchange> fetchBasedOnCountryNames(@RequestParam String from, @RequestParam String to);

}
