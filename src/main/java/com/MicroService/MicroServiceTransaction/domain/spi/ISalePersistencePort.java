package com.MicroService.MicroServiceTransaction.domain.spi;

import com.MicroService.MicroServiceTransaction.domain.models.Sale;

public interface ISalePersistencePort {
    void updateSale(Sale sale);
    Sale createSale(Sale sale);

}
