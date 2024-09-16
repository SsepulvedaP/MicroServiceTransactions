package com.MicroService.MicroServiceTransaction.domain.api;

import com.MicroService.MicroServiceTransaction.domain.models.Supply;

public interface ISupplyServicePort {
    void saveSupply(Supply supply, String token);
}
