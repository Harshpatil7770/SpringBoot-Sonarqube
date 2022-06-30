package com.cls.ccurrencyonversion.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cls.ccurrencyonversion.dao.CurrencyConversionRepo;
import com.cls.ccurrencyonversion.model.CurrencyConversion;

@ExtendWith(MockitoExtension.class)
class CurrencyConversionServiceImplTest {

	@Mock
	CurrencyConversionRepo conversionRepo;

	@InjectMocks
	CurrencyConversionServiceImpl currencyConversionServiceImpl;

	private CurrencyConversion currencyConversion;

	@BeforeEach
	void setup() {
		currencyConversion = new CurrencyConversion(101, "USD", "INR", BigDecimal.valueOf(75),
				BigDecimal.valueOf(15000));

	}

	@Test
	void addNewCurrencyConversionDetails() {
		when(conversionRepo.save(currencyConversion)).thenReturn(currencyConversion);
		assertEquals("New currency Conversion Details added Succesfully",
				currencyConversionServiceImpl.addNewCurrencyConversionDetails(currencyConversion));
	}
	
	

}
