package com.cls.ccurrencyonversion.model;

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
@Table(name = "currency_conversion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "currency_from")
	private String from;

	@Column(name = "currency_to")
	private String to;

	@Column(name = "quantity")
	private BigDecimal quantity;

	@Column(name = "total_amount")
	private BigDecimal totalAmount;
}
