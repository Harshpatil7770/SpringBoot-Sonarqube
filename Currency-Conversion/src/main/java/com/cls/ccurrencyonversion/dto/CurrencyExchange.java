package com.cls.ccurrencyonversion.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchange {

	private int id;
	
	private String from;

	private String to;

	private BigDecimal conversionMultiple;
}
