package com.MicroService.MicroServiceTransaction.infrastructure.jpa.mapper;

import com.MicroService.MicroServiceTransaction.domain.models.Supply;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.entity.SupplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface SupplyEntityMapper {
    @Mapping(target = "productId", source = "productId")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "date", source = "date")
    SupplyEntity toSupplyEntity(Supply supply);

}
