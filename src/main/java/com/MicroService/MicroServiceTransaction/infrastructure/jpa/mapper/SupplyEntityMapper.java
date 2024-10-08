package com.MicroService.MicroServiceTransaction.infrastructure.jpa.mapper;

import com.MicroService.MicroServiceTransaction.domain.models.Supply;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.entity.SupplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface SupplyEntityMapper {
    @Mapping(source = "productId", target = "productId")
    SupplyEntity toSupplyEntity(Supply supply);

}
