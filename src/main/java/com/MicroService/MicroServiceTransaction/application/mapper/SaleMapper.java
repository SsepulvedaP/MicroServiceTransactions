package com.MicroService.MicroServiceTransaction.application.mapper;

import com.MicroService.MicroServiceTransaction.application.dto.request.SaleRequest;
import com.MicroService.MicroServiceTransaction.application.dto.response.SaleResponse;
import com.MicroService.MicroServiceTransaction.domain.models.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SaleMapper {

    @Mapping(source = "saleItems", target = "saleItems")
    @Mapping(source = "totalAmount", target = "totalAmount")
    Sale toSale(SaleRequest saleRequest);


    SaleResponse toSaleResponse(Sale sale);
}