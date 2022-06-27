package com.xoriant.settlement.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.xoriant.settlement.dao.CurrencyExchangeDao;
import com.xoriant.settlement.dto.CurrencyExchangeDTO;
import com.xoriant.settlement.model.CurrencyExchange;

@ExtendWith(MockitoExtension.class) // It provide mock object for you
class CurrencyExchangeServiceImplTest {

	@Mock
	CurrencyExchangeDao currencyExchangeDao; // It create the mock object

	@InjectMocks
	CurrencyExchangeServiceImpl currencyExchangeServiceImpl; // It create the instance and
	// inject all necessary objects

	private CurrencyExchange currencyExchange;

	private CurrencyExchangeDTO currencyExchangeDTO;

	private CurrencyExchange currencyExchange1;

	@BeforeEach
	void setUp() {

		currencyExchangeDTO = new CurrencyExchangeDTO(101, "USD", "INR", BigDecimal.valueOf(74));

		currencyExchange = new CurrencyExchange(currencyExchangeDTO.getId(), currencyExchangeDTO.getFrom(),
				currencyExchangeDTO.getTo(), currencyExchangeDTO.getConversionMultiple());

		currencyExchange1 = new CurrencyExchange(501, "USD", "INR", BigDecimal.valueOf(75));
	}

	@Test
	void addNewCurrencyExchangeDetails() {

		when(currencyExchangeDao.save(currencyExchange)).thenReturn(currencyExchange);
		CurrencyExchange result = currencyExchangeDao.save(currencyExchange);
		assertNotNull(result);
		assertEquals(
				"New Currency Exchange Details Added Succesfully !!!\n+" + "Form :: " + currencyExchange.getFrom()
						+ " To:: " + currencyExchange.getTo(),
				currencyExchangeServiceImpl.addNewCurrencyExchangeDatails(currencyExchangeDTO));
	}


	@Test
	void updateNewCurrencyExchageDetails() {
		Optional<CurrencyExchange> exisitingCurrencyExhchange = Optional.of(currencyExchange);
		when(currencyExchangeDao.findById(101)).thenReturn(exisitingCurrencyExhchange);
		Optional<CurrencyExchange> result = currencyExchangeDao.findById(101);
		assertNotNull(result);
		currencyExchangeDTO.setFrom("AUT");
		currencyExchangeDTO.setTo("INR");
		BigDecimal bigDecimal = new BigDecimal(45);
		currencyExchangeDTO.setConversionMultiple(bigDecimal);

		currencyExchange.setId(currencyExchangeDTO.getId());
		currencyExchange.setFrom(currencyExchangeDTO.getFrom());
		currencyExchange.setTo(currencyExchangeDTO.getTo());
		currencyExchange.setConversionMultiple(currencyExchangeDTO.getConversionMultiple());

		currencyExchangeDao.save(currencyExchange);

		when(currencyExchangeDao.save(currencyExchange)).thenReturn(currencyExchange);
		assertEquals(
				"Updated currency Exchange Details Succesfully From : " + currencyExchange.getFrom() + " To :"
						+ currencyExchange.getTo(),
				currencyExchangeServiceImpl.updateCurrencyExchangeDetails(currencyExchangeDTO));
	}

	@Test
	void addNewListsOfCurrencyExchangeDetails() {
		List<CurrencyExchange> currencyExchangeLists = new ArrayList<CurrencyExchange>();

		CurrencyExchange currencyExchange2 = new CurrencyExchange(502, "USD", "INR", BigDecimal.valueOf(79));
		currencyExchangeLists.add(currencyExchange1);
		currencyExchangeLists.add(currencyExchange2);

		when(currencyExchangeDao.saveAll(currencyExchangeLists)).thenReturn(currencyExchangeLists);
		assertEquals(currencyExchangeLists,
				currencyExchangeServiceImpl.addNewListsOfCurrencyExchangeDetails(currencyExchangeLists));

	}

	@Test
	void updateListOfCurrencyExchangeDetails() {
		List<CurrencyExchange> updatedexchangeLists = new ArrayList<CurrencyExchange>();

		Optional<CurrencyExchange> existingCurrencyExchange1 = Optional.of(currencyExchange);
		when(currencyExchangeDao.findById(101)).thenReturn(existingCurrencyExchange1);
		Optional<CurrencyExchange> result1 = currencyExchangeDao.findById(101);
		assertNotNull(result1);
		currencyExchange.setFrom("INR");
		currencyExchange.setTo("USD");
		currencyExchange.setConversionMultiple(BigDecimal.valueOf(0.75));
		updatedexchangeLists.add(currencyExchange);

		Optional<CurrencyExchange> exitingCurrencyExchnage2 = Optional.of(currencyExchange1);
		when(currencyExchangeDao.findById(501)).thenReturn(exitingCurrencyExchnage2);
		Optional<CurrencyExchange> result2 = currencyExchangeDao.findById(501);
		assertNotNull(result2);
		currencyExchange1.setFrom("INR");
		currencyExchange1.setTo("USD");
		currencyExchange1.setConversionMultiple(BigDecimal.valueOf(0.73));
		updatedexchangeLists.add(currencyExchange1);

		assertThat(currencyExchangeServiceImpl.updateListOfCurrencyExchangeDetails(updatedexchangeLists))
				.isEqualTo("Update Lists Of Currency Exchange Details");
		assertEquals("Update Lists Of Currency Exchange Details",
				currencyExchangeServiceImpl.updateListOfCurrencyExchangeDetails(updatedexchangeLists));
	}

	// verify method is used to check the method is called or not also to test void
	// method we use verify() method
	@Test
	void deleteCurrecyExchangeDetails() {

		int id = 101;
		Optional<CurrencyExchange> existingCurrencyExchange = Optional.of(currencyExchange);
		when(currencyExchangeDao.findById(id)).thenReturn(existingCurrencyExchange);
		Optional<CurrencyExchange> result = currencyExchangeDao.findById(101);
		assertNotNull(result);
		currencyExchangeServiceImpl.deleteCurrecyExchangeDetails(id);
		verify(currencyExchangeDao, times(1)).deleteById(id);
	}

	@Test
	void fetchAllListsOfCurrencyDetails() {
		List<CurrencyExchange> currecnyExchangeLists = new ArrayList<>();
		currecnyExchangeLists.add(currencyExchange);
		currecnyExchangeLists.add(currencyExchange1);

		when(currencyExchangeDao.findAll()).thenReturn(currecnyExchangeLists);
		assertEquals(2, currencyExchangeServiceImpl.fetchAllListsOfCurrencyDetails().size());
	}

	@Test
	void fetchBasedOnCountryNames() {
		String from = "USD";
		String to = "INR";
		List<CurrencyExchange> currecnyExchangeLists = new ArrayList<>();
		currecnyExchangeLists.add(currencyExchange);
		currecnyExchangeLists.add(currencyExchange1);

		when(currencyExchangeDao.findByFromAndTo(from, to)).thenReturn(currecnyExchangeLists);
		assertEquals(2, currencyExchangeServiceImpl.fetchBasedOnCountryNames(from, to).size());
		assertEquals(currecnyExchangeLists, currencyExchangeServiceImpl.fetchBasedOnCountryNames(from, to));
	}

	@Test
	void fetchCurrencyExchangeDetailsBasedOnId() {
		int id = 101;
		Optional<CurrencyExchange> exitingCurrencyExchange = Optional.of(currencyExchange);
		when(currencyExchangeDao.findById(id)).thenReturn(exitingCurrencyExchange);
		Optional<CurrencyExchange> result = currencyExchangeDao.findById(id);
		assertNotNull(result);
		assertEquals(exitingCurrencyExchange, currencyExchangeServiceImpl.fetchCurrencyExchangeDetailsBasedOnId(id));
	}

}
