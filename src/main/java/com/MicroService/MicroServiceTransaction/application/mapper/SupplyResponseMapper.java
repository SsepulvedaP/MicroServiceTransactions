package com.MicroService.MicroServiceTransaction.application.mapper;

import com.MicroService.MicroServiceTransaction.application.dto.response.SupplyResponse;
import com.MicroService.MicroServiceTransaction.domain.models.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplyResponseMapper {


    SupplyResponse ToSupplyResponse(Supply supply);
}
