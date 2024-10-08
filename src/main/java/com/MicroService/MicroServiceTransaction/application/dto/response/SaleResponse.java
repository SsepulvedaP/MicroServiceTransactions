package com.MicroService.MicroServiceTransaction.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SaleResponse {
    private LocalDateTime purchaseDate;
    private double totalAmount;
    private List<SaleItemResponse> saleItems;
    private String userEmail;
}
