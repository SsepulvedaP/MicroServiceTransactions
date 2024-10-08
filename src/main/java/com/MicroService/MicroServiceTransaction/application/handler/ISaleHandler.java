package com.MicroService.MicroServiceTransaction.application.handler;

import com.MicroService.MicroServiceTransaction.application.dto.request.SaleRequest;
import com.MicroService.MicroServiceTransaction.application.dto.response.SaleResponse;

public interface ISaleHandler {
    SaleResponse createSale(SaleRequest saleRequest, Long userId, String userEmail, String token);
}
