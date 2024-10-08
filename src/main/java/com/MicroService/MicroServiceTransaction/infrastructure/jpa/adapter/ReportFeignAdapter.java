package com.MicroService.MicroServiceTransaction.infrastructure.jpa.adapter;

import com.MicroService.MicroServiceTransaction.application.dto.request.ReportItemRequest;
import com.MicroService.MicroServiceTransaction.application.dto.request.ReportRequest;
import com.MicroService.MicroServiceTransaction.domain.models.Sale;
import com.MicroService.MicroServiceTransaction.domain.spi.IReportPersistencePort;
import com.MicroService.MicroServiceTransaction.infrastructure.feign.client.ReportFeignClient;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ReportFeignAdapter implements IReportPersistencePort {
    private final ReportFeignClient reportFeignClient;


    @Override
    public void generateReport(Sale sale) {
        ReportRequest reportRequest = new ReportRequest();
        reportRequest.setUserId(sale.getUserId());
        reportRequest.setUserEmail(sale.getUserEmail());
        reportRequest.setPurchaseDate(sale.getPurchaseDate());
        reportRequest.setTotalAmount(sale.getTotalAmount());

        reportRequest.setItems(sale.getSaleItems().stream().map(item -> {
            ReportItemRequest reportItem = new ReportItemRequest();
            reportItem.setProductId(item.getProductId());
            reportItem.setProductName(item.getProductName());
            reportItem.setQuantity(item.getQuantity());
            reportItem.setPrice(item.getPrice());
            reportItem.setPurchaseDate(sale.getPurchaseDate());
            return reportItem;
        }).toList());

        reportFeignClient.createPurchaseReport(reportRequest);
    }
}
