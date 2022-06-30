package com.cls.ccurrencyonversion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cls.ccurrencyonversion.model.CurrencyConversion;

public interface CurrencyConversionRepo extends JpaRepository<CurrencyConversion, Integer> {

}
