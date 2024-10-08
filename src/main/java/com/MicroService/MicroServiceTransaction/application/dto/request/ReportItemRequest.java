package com.MicroService.MicroServiceTransaction.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class ReportItemRequest {
    private Long productId;
    private String productName;
    private int quantity;
    private double price;
    private LocalDateTime purchaseDate;
}
