package com.indra.currencyexchange.controller;

import com.indra.currencyexchange.dto.request.CurrencyRequest;
import com.indra.currencyexchange.dto.response.CurrencyResponse;
import com.indra.currencyexchange.service.ICurrencyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/currency")
public class CurrencyRestController {

    private final ICurrencyService changeTypeService;

    public CurrencyRestController(ICurrencyService changeTypeService) {
        this.changeTypeService = changeTypeService;
    }

    @GetMapping
    public List<CurrencyResponse> findAll() {
        return changeTypeService.findAll()
                .stream()
                .map(c -> new CurrencyResponse(c.getId(),
                        c.getOriginCurrency(),
                        c.getDestinationCurrency(),
                        c.getChangeType()))
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/{id}")
    public CurrencyResponse update(@PathVariable(name = "id") Long id, @RequestBody CurrencyRequest request) {
        return changeTypeService.update(id, request).toResponse();
    }

}
