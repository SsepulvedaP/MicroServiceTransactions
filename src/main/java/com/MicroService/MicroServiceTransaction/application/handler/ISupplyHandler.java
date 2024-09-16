package com.MicroService.MicroServiceTransaction.application.handler;

import com.MicroService.MicroServiceTransaction.application.dto.request.SupplyRequest;

public interface ISupplyHandler {
    void saveSupply(SupplyRequest supplyRequest, Long userId, String token);
}
