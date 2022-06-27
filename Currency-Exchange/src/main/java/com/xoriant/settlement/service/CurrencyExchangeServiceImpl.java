package com.xoriant.settlement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.settlement.dao.CurrencyExchangeDao;
import com.xoriant.settlement.dto.CurrencyExchangeDTO;
import com.xoriant.settlement.expection.CurrencyDetailsNotFoundException;
import com.xoriant.settlement.expection.ElementNotFoundException;
import com.xoriant.settlement.expection.UserInputException;
import com.xoriant.settlement.model.CurrencyExchange;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	@Autowired
	CurrencyExchangeDao currencyExchangeDao;

	@Override
	public String addNewCurrencyExchangeDatails(CurrencyExchangeDTO currencyExchangeDTO) {
		if (currencyExchangeDTO.getFrom().isBlank() || currencyExchangeDTO.getFrom().isEmpty()) {
			throw new UserInputException();
		}
		if (currencyExchangeDTO.getTo().isBlank() || currencyExchangeDTO.getTo().isEmpty()) {
			throw new UserInputException();
		}

		CurrencyExchange currencyExchange = new CurrencyExchange();
		currencyExchange.setFrom(currencyExchangeDTO.getFrom());
		currencyExchange.setTo(currencyExchangeDTO.getTo());
		currencyExchange.setConversionMultiple(currencyExchangeDTO.getConversionMultiple());
		currencyExchangeDao.save(currencyExchange);
		String result = "New Currency Exchange Details Added Succesfully !!!\n+" + "Form :: "
				+ currencyExchange.getFrom() + " To:: " + currencyExchange.getTo();
		return result;
	}

	// If refenrece varaible referes to the null values
	@Override
	public String updateCurrencyExchangeDetails(CurrencyExchangeDTO currencyExchangeDTO) {
		Optional<CurrencyExchange> exitingCurrencyExchangeDeatils = currencyExchangeDao
				.findById(currencyExchangeDTO.getId());
		if (!exitingCurrencyExchangeDeatils.isPresent()) {
			throw new CurrencyDetailsNotFoundException();
		}

		if (currencyExchangeDTO.getFrom().isBlank() || currencyExchangeDTO.getFrom().isEmpty()) {
			throw new UserInputException();
		}
		if (currencyExchangeDTO.getTo().isBlank() || currencyExchangeDTO.getTo().isEmpty()) {
			throw new UserInputException();
		}

		CurrencyExchange existingCurrencyExchange = currencyExchangeDao.findById(currencyExchangeDTO.getId())
				.orElse(null);
		existingCurrencyExchange.setId(currencyExchangeDTO.getId());
		existingCurrencyExchange.setFrom(currencyExchangeDTO.getFrom());
		existingCurrencyExchange.setTo(currencyExchangeDTO.getTo());
		existingCurrencyExchange.setConversionMultiple(currencyExchangeDTO.getConversionMultiple());
		currencyExchangeDao.save(existingCurrencyExchange);
		return "Updated currency Exchange Details Succesfully From : " + currencyExchangeDTO.getFrom() + " To :"
				+ currencyExchangeDTO.getTo();
	}

	@Override
	public List<CurrencyExchange> addNewListsOfCurrencyExchangeDetails(List<CurrencyExchange> currencyExchangeLists) {

		// check entering input null or not
		for (CurrencyExchange eachCurrencyExchange : currencyExchangeLists) {

			if (eachCurrencyExchange.getFrom().isBlank() || eachCurrencyExchange.getFrom().isEmpty()) {
				throw new UserInputException();
			}
			if (eachCurrencyExchange.getTo().isBlank() || eachCurrencyExchange.getTo().isEmpty()) {
				throw new UserInputException();
			}
		}

		return currencyExchangeDao.saveAll(currencyExchangeLists);
	}

	@Override
	public String updateListOfCurrencyExchangeDetails(List<CurrencyExchange> currencyExchangeLists) {

		for (CurrencyExchange eachCurrencyExchange : currencyExchangeLists) {

			Optional<CurrencyExchange> isExit = currencyExchangeDao.findById(eachCurrencyExchange.getId());
			if (!isExit.isPresent()) {
				throw new ElementNotFoundException();
			}

			if (eachCurrencyExchange.getFrom().isBlank() || eachCurrencyExchange.getFrom().isEmpty()) {
				throw new UserInputException();
			}
			if (eachCurrencyExchange.getTo().isBlank() || eachCurrencyExchange.getTo().isEmpty()) {
				throw new UserInputException();
			}
		}

		for (CurrencyExchange eachCurrencyExchange : currencyExchangeLists) {
			CurrencyExchange updatedCurrencyExchangeDetails = currencyExchangeDao.findById(eachCurrencyExchange.getId())
					.orElse(null);
			updatedCurrencyExchangeDetails.setId(eachCurrencyExchange.getId());
			updatedCurrencyExchangeDetails.setFrom(eachCurrencyExchange.getFrom());
			updatedCurrencyExchangeDetails.setTo(eachCurrencyExchange.getTo());
			updatedCurrencyExchangeDetails.setConversionMultiple(eachCurrencyExchange.getConversionMultiple());
			currencyExchangeDao.save(updatedCurrencyExchangeDetails);
		}
		return "Update Lists Of Currency Exchange Details";

	}

	@Override
	public void deleteCurrecyExchangeDetails(int id) {
		Optional<CurrencyExchange> existingCurrencyExchange = currencyExchangeDao.findById(id);
		if (!existingCurrencyExchange.isPresent()) {
			throw new ElementNotFoundException();
		}
		currencyExchangeDao.deleteById(id);
	}

	@Override
	public List<CurrencyExchange> fetchAllListsOfCurrencyDetails() {
		return currencyExchangeDao.findAll();
	}

	@Override
	public List<CurrencyExchange> fetchBasedOnCountryNames(String from, String to) {
		return currencyExchangeDao.findByFromAndTo(from, to);
	}

	@Override
	public Optional<CurrencyExchange> fetchCurrencyExchangeDetailsBasedOnId(int id) {
		Optional<CurrencyExchange> existingCurrencyExchange = currencyExchangeDao.findById(id);
		if (!existingCurrencyExchange.isPresent()) {
			throw new ElementNotFoundException();
		}
		return existingCurrencyExchange;
	}

}
