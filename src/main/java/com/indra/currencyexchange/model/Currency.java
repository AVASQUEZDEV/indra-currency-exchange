package com.indra.currencyexchange.model;

import com.indra.currencyexchange.dto.response.CurrencyResponse;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "change_type")
@Data
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origin_currency")
    private String originCurrency;

    @Column(name = "destination_currency")
    private String destinationCurrency;

    @Column(name = "change_type")
    private double changeType;

    public Currency() {
    }

    public Currency(String originCurrency, String destinationCurrency, double changeType) {
        this.originCurrency = originCurrency;
        this.destinationCurrency = destinationCurrency;
        this.changeType = changeType;
    }

    public CurrencyResponse toResponse() {
        return new CurrencyResponse(getId(), getOriginCurrency(), getDestinationCurrency(), getChangeType());
    }

    public List<CurrencyResponse> toList(List<Currency> currency) {
        return currency.stream()
                .map(c -> toResponse())
                .collect(Collectors.toList());
    }

}
