package com.MicroService.MicroServiceTransaction.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ReportRequest {
    private Long userId;
    private String userEmail;
    private LocalDateTime purchaseDate;
    private double totalAmount;
    private List<ReportItemRequest> items;
}
