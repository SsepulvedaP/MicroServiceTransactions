package com.MicroService.MicroServiceTransaction.domain.spi;

public interface IShoppingCartPersistencePort {
    void deleteProductFromShoppingCart(Long productId);
}
