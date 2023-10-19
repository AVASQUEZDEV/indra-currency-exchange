package com.indra.currencyexchange.service;

import com.indra.currencyexchange.dto.request.ChangeTypeRequest;
import com.indra.currencyexchange.dto.response.ChangeTypeResponse;

public interface IChangeTypeService {

    ChangeTypeResponse calculateChangeType(ChangeTypeRequest request);

}
