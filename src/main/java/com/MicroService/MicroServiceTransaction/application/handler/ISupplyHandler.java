package com.MicroService.MicroServiceTransaction.application.handler;

import com.MicroService.MicroServiceTransaction.application.dto.request.SupplyRequest;

import java.time.LocalDateTime;

public interface ISupplyHandler {
    void saveSupply(SupplyRequest supplyRequest, Long userId, String token);
    LocalDateTime nextSupplyDate(Long productId);

}
