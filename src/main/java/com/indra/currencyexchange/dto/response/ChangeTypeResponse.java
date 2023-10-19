package com.indra.currencyexchange.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChangeTypeResponse {

    @JsonProperty(value = "amount")
    private double amount;

    @JsonProperty(value = "changeAmount")
    private double changeAmount;

    @JsonProperty(value = "originCurrency")
    private String originCurrency;

    @JsonProperty(value = "destinationCurrency")
    private String destinationCurrency;

    @JsonProperty(value = "changeType")
    private double changeType;

    public ChangeTypeResponse(double amount, double changeAmount, String originCurrency,
                              String destinationCurrency, double changeType) {
        this.amount = amount;
        this.changeAmount = changeAmount;
        this.originCurrency = originCurrency;
        this.destinationCurrency = destinationCurrency;
        this.changeType = changeType;
    }

}
