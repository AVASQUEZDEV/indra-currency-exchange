package com.indra.currencyexchange.service;

import com.indra.currencyexchange.dto.request.CurrencyRequest;
import com.indra.currencyexchange.model.Currency;

import java.util.List;

public interface ICurrencyService {

    Currency update(Long id, CurrencyRequest request);
    Currency findById(Long id);
    List<Currency> findAll();

}
