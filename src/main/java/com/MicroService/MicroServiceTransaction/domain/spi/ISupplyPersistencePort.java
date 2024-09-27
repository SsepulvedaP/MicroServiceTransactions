package com.MicroService.MicroServiceTransaction.domain.spi;

import com.MicroService.MicroServiceTransaction.domain.models.Supply;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ISupplyPersistencePort {
    void saveSupply(Supply supply);
    Optional<LocalDateTime> findLastSupplyDateByProductId(Long productId);
}
