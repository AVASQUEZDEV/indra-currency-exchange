package com.indra.currencyexchange.repository;

import com.indra.currencyexchange.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICurrencyRepository extends JpaRepository<Currency, Long> {
}
