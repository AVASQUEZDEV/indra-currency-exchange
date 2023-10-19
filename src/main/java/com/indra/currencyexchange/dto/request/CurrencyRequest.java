package com.indra.currencyexchange.dto.request;

import lombok.Data;

@Data
public class CurrencyRequest {

    private String originCurrency;
    private String destinationCurrency;
    private double changeType;

}
