package com.indra.currencyexchange.dto.request;

import lombok.Data;

@Data
public class ChangeTypeRequest {

    private double amount;
    private String originCurrency;
    private String destinationCurrency;

}
