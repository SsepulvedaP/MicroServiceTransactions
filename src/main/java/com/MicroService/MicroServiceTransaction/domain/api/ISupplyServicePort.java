package com.MicroService.MicroServiceTransaction.domain.api;

import com.MicroService.MicroServiceTransaction.domain.models.Supply;

import java.time.LocalDateTime;

public interface ISupplyServicePort {
    void saveSupply(Supply supply, String token);
    LocalDateTime nextSupplyDate(Long productId);
}
