package com.MicroService.MicroServiceTransaction.application.mapper;

import com.MicroService.MicroServiceTransaction.application.dto.request.SupplyRequest;
import com.MicroService.MicroServiceTransaction.domain.models.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplyRequestMapper {
    @Mapping(source = "productId", target = "productId")
    Supply ToSupply(SupplyRequest supplyRequest);
}
