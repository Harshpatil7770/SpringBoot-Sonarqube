package com.xoriant.settlement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.settlement.model.CurrencyExchange;

@Repository
public interface CurrencyExchangeDao extends JpaRepository<CurrencyExchange, Integer> {

	List<CurrencyExchange> findByFromAndTo(String from, String to);

}
