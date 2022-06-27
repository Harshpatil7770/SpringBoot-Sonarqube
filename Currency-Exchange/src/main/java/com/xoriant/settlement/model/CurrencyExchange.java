package com.xoriant.settlement.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "currency_exchange")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	@NotEmpty // not be bull or empty
	@Column(name = "currency_from", nullable = false)
	private String from;

//	@NotEmpty
	@Column(name = "currency_to", nullable = false)
	private String to;

	@Column(name = "conversion_multiple", nullable = false)
	private BigDecimal conversionMultiple;

}
