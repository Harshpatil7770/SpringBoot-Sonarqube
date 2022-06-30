package com.cls.ccurrencyonversion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cls.ccurrencyonversion.dao.CurrencyConversionRepo;
import com.cls.ccurrencyonversion.dto.CurrencyExchange;
import com.cls.ccurrencyonversion.dto.CurrencyExchangeDTO;
import com.cls.ccurrencyonversion.exception.ElementNotFoundException;
import com.cls.ccurrencyonversion.model.CurrencyConversion;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

	@Autowired
	CurrencyConversionRepo conversionRepo;

	@Autowired
	CurrencyConversionProxy currencyConversionProxy;

	@Override
	public String addNewCurrencyConversionDetails(CurrencyConversion currencyConversion) {

		conversionRepo.save(currencyConversion);
		return "New currency Conversion Details added Succesfully";
	}

	@Override
	public String addNewCurrencyExchangeDetails(CurrencyExchangeDTO currencyExchangeDTO) {

		currencyConversionProxy.addNewCurrencyExchangeDetails(currencyExchangeDTO);
		return "New Currency Exchange Details Added Succesfully";
	}

	@Override
	public Optional<CurrencyExchange> fetchCurrencyExchangeDetailsBasedOnId(int id) {
		Optional<CurrencyExchange> result = currencyConversionProxy.fetchCurrencyExchangeDetailsBasedOnId(id);
		if (!result.isPresent()) {
			throw new ElementNotFoundException();
		}
		return result;
	}

	@Override
	public String updateListOfCurrencyExchangeDetails(List<CurrencyExchange> currencyExchangeLists) {
		return currencyConversionProxy.updateListOfCurrencyExchangeDetails(currencyExchangeLists);
	}

	@Override
	public void deleteCurrecyExchangeDetails(int id) {
		currencyConversionProxy.deleteCurrecyExchangeDetails(id);
	}

	@Override
	public List<CurrencyExchange> fetchAllListsOfCurrencyDetails() {
		return currencyConversionProxy.fetchAllListsOfCurrencyDetails();
	}

	@Override
	public List<CurrencyExchange> fetchBasedOnCountryNames(String from, String to) {
		return currencyConversionProxy.fetchBasedOnCountryNames(from, to);
	}
}
