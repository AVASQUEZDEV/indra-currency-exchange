package com.indra.currencyexchange.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrencyResponse {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "originCurrency")
    private String originCurrency;

    @JsonProperty(value = "destinationCurrency")
    private String destinationCurrency;

    @JsonProperty(value = "changeType")
    private double changeType;

    public CurrencyResponse(Long id, String originCurrency, String destinationCurrency, double changeType) {
        this.id = id;
        this.originCurrency = originCurrency;
        this.destinationCurrency = destinationCurrency;
        this.changeType = changeType;
    }

}
