package com.MicroService.MicroServiceTransaction.infrastructure.jpa.mapper;

import com.MicroService.MicroServiceTransaction.domain.models.Sale;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.entity.SaleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SaleEntityMapper {

    @Mapping(target = "saleItems", source = "saleItems")
    SaleEntity toEntity(Sale sale);

    @Mapping(target = "saleItems", source = "saleItems")
    Sale toDomain(SaleEntity saleEntity);
}
