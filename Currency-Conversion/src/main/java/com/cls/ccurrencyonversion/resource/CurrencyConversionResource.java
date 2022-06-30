package com.cls.ccurrencyonversion.resource;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cls.ccurrencyonversion.dto.CurrencyExchange;
import com.cls.ccurrencyonversion.model.CurrencyConversion;
import com.cls.ccurrencyonversion.msgsender.MessageSender;
import com.cls.ccurrencyonversion.service.CurrencyConversionService;

@RestController
@RequestMapping("/api/currency-conversion")
public class CurrencyConversionResource {

	@Autowired
	CurrencyConversionService currencyConversionService;

	@Autowired
	MessageSender messageSender;

	@PostMapping("/save/{id}/{quantity}")
	public String addNewCurrencyConversionDetails(@PathVariable int id, @PathVariable BigDecimal quantity) {
		Optional<CurrencyExchange> result = currencyConversionService.fetchCurrencyExchangeDetailsBasedOnId(id);

		CurrencyConversion currencyConversion = new CurrencyConversion();
		currencyConversion.setId(id);
		currencyConversion.setFrom(result.get().getFrom());
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTo(result.get().getTo());
		currencyConversion.setTotalAmount(quantity.multiply(result.get().getConversionMultiple()));
		currencyConversionService.addNewCurrencyConversionDetails(currencyConversion);
		String msg = "New Currency Conversion Details Added Succesfully" + currencyConversion.getFrom() + " To "
				+ currencyConversion.getTo();
		if (result != null) {
			messageSender.addNewCurrencyConversionDetails(msg);
		}
		return msg;
	}

	@PutMapping("/update")
	public String updateListOfCurrencyExchangeDetails(List<CurrencyExchange> currencyExchangeLists) {
		return currencyConversionService.updateListOfCurrencyExchangeDetails(currencyExchangeLists);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteCurrecyExchangeDetails(@PathVariable int id) {
		currencyConversionService.deleteCurrecyExchangeDetails(id);
	}

	@GetMapping("/fetchAll")
	public List<CurrencyExchange> fetchAllListsOfCurrencyDetails() {
		return currencyConversionService.fetchAllListsOfCurrencyDetails();
	}

	@GetMapping("/fetch/{from}/{to}")
	public List<CurrencyExchange> fetchBasedOnCountryNames(@PathVariable String from, @PathVariable String to) {
		return currencyConversionService.fetchBasedOnCountryNames(from, to);
	}
}
