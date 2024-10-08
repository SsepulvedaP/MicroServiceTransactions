package com.MicroService.MicroServiceTransaction.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleItemRequest {
    private Long productId;
    private int quantity;
    private double price;
}
