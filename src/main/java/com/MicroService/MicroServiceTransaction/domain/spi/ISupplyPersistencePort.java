package com.MicroService.MicroServiceTransaction.domain.spi;

import com.MicroService.MicroServiceTransaction.domain.models.Supply;

public interface ISupplyPersistencePort {
    void saveSupply(Supply supply);
}
