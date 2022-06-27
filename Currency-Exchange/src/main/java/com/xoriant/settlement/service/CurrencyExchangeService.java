package com.xoriant.settlement.service;

import java.util.List;
import java.util.Optional;

import com.xoriant.settlement.dto.CurrencyExchangeDTO;
import com.xoriant.settlement.model.CurrencyExchange;

public interface CurrencyExchangeService {

	String addNewCurrencyExchangeDatails(CurrencyExchangeDTO currencyExchangeDTO);

	String updateCurrencyExchangeDetails(CurrencyExchangeDTO currencyExchangeDTO);

	List<CurrencyExchange> addNewListsOfCurrencyExchangeDetails(List<CurrencyExchange> currencyExchangeLists);

	String updateListOfCurrencyExchangeDetails(List<CurrencyExchange> currencyExchangeLists);

	void deleteCurrecyExchangeDetails(int id);

	List<CurrencyExchange> fetchAllListsOfCurrencyDetails();

	List<CurrencyExchange> fetchBasedOnCountryNames(String from, String to);

	Optional<CurrencyExchange> fetchCurrencyExchangeDetailsBasedOnId(int id);

}
