package com.indra.currencyexchange.service.impl;

import com.indra.currencyexchange.dto.request.CurrencyRequest;
import com.indra.currencyexchange.model.Currency;
import com.indra.currencyexchange.repository.ICurrencyRepository;
import com.indra.currencyexchange.service.ICurrencyService;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CurrencyServiceImpl implements ICurrencyService {

    private final ICurrencyRepository currencyRepository;

    public CurrencyServiceImpl(ICurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Currency update(Long id, CurrencyRequest request) {
        Currency currency = findById(id);
        currency.setOriginCurrency(request.getOriginCurrency());
        currency.setDestinationCurrency(request.getDestinationCurrency());
        currency.setChangeType(request.getChangeType());
        return currencyRepository.save(currency);
    }

    @Override
    public Currency findById(Long id) {
        return currencyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Charge type not found"));
    }

    @Override
    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

}
