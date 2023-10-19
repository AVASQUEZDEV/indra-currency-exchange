package com.indra.currencyexchange.controller;

import com.indra.currencyexchange.dto.request.ChangeTypeRequest;
import com.indra.currencyexchange.dto.response.ChangeTypeResponse;
import com.indra.currencyexchange.service.IChangeTypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/change-type")
public class ChangeTypeRestController {

    private final IChangeTypeService changeTypeService;

    public ChangeTypeRestController(IChangeTypeService changeTypeService) {
        this.changeTypeService = changeTypeService;
    }

    @PostMapping
    public ChangeTypeResponse calculateChangeType(@RequestBody ChangeTypeRequest request) {
       return changeTypeService.calculateChangeType(request);
    }

}
