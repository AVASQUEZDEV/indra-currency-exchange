package com.indra.currencyexchange.service.impl;

import com.indra.currencyexchange.dto.request.ChangeTypeRequest;
import com.indra.currencyexchange.dto.response.ChangeTypeResponse;
import com.indra.currencyexchange.model.Currency;
import com.indra.currencyexchange.service.IChangeTypeService;
import com.indra.currencyexchange.service.ICurrencyService;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.DecimalFormat;

@Service
public class ChangeTypeServiceImpl implements IChangeTypeService {

    private final ICurrencyService currencyService;

    public ChangeTypeServiceImpl(ICurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Override
    public ChangeTypeResponse calculateChangeType(ChangeTypeRequest request) {
        Currency currency = currencyService.findAll()
                .stream()
                .filter(c -> c.getOriginCurrency().equals(request.getOriginCurrency()) &&
                        c.getDestinationCurrency().equals(request.getDestinationCurrency()))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Currency type not found"));

        double changeAmount = calculate(request.getAmount(), currency.getChangeType());
        return new ChangeTypeResponse(
                request.getAmount(),
                changeAmount,
                request.getOriginCurrency(),
                request.getDestinationCurrency(),
                currency.getChangeType()
        );
    }

    private double calculate(double amount, double changeType) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(amount / changeType));
    }

}
