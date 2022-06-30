package com.cls.ccurrencyonversion.service;

import java.util.List;
import java.util.Optional;

import com.cls.ccurrencyonversion.dto.CurrencyExchange;
import com.cls.ccurrencyonversion.dto.CurrencyExchangeDTO;
import com.cls.ccurrencyonversion.model.CurrencyConversion;

public interface CurrencyConversionService {

	String addNewCurrencyConversionDetails(CurrencyConversion currencyConversion);

	String addNewCurrencyExchangeDetails(CurrencyExchangeDTO currencyExchangeDTO);

	Optional<CurrencyExchange> fetchCurrencyExchangeDetailsBasedOnId(int id);

	String updateListOfCurrencyExchangeDetails(List<CurrencyExchange> currencyExchangeLists);

	void deleteCurrecyExchangeDetails(int id);

	List<CurrencyExchange> fetchAllListsOfCurrencyDetails();

	List<CurrencyExchange> fetchBasedOnCountryNames(String from, String to);

}
