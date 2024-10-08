package com.MicroService.MicroServiceTransaction.infrastructure.jpa.mapper;

import com.MicroService.MicroServiceTransaction.domain.models.SaleItem;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.entity.SaleItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SaleItemEntityMapper {
    SaleItemEntityMapper INSTANCE = Mappers.getMapper(SaleItemEntityMapper.class);

    SaleItemEntity toEntity(SaleItem saleItem);

    SaleItem toDomain(SaleItemEntity saleItemEntity);
}
