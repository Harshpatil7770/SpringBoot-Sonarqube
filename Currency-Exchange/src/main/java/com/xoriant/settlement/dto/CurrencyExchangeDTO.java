package com.xoriant.settlement.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchangeDTO {

	private int id;
	
	private String from;

	private String to;

	private BigDecimal conversionMultiple;
}
