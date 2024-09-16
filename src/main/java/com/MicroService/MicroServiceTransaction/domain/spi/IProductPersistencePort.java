package com.MicroService.MicroServiceTransaction.domain.spi;

public interface IProductPersistencePort {
    void updateProductQuantity(Long productId, int quantity);

}
