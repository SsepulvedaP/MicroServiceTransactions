package com.MicroService.MicroServiceTransaction.application.dto.request;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SaleRequest {
    private List<SaleItemRequest> saleItems;
    private double totalAmount;
}
