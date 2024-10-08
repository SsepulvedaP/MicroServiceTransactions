package com.MicroService.MicroServiceTransaction.domain.api;

import com.MicroService.MicroServiceTransaction.domain.models.Sale;

public interface ISaleServicePort {
    Sale createSale(Sale sale, Long userId, String userEmail, String token);
}
