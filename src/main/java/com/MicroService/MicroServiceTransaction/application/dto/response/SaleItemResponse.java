package com.MicroService.MicroServiceTransaction.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleItemResponse {
    private Long productId;
    private String productName;
    private int quantity;
    private double price;
}
