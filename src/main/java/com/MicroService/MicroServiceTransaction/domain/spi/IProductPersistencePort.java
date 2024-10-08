package com.MicroService.MicroServiceTransaction.domain.spi;

import com.MicroService.MicroServiceTransaction.domain.models.Product;

public interface IProductPersistencePort {
    void updateProductQuantity(Long productId, int quantity);
    Product getProductById(Long productId);
    void reduceProductQuantity(Long productId, int quantity);
}
