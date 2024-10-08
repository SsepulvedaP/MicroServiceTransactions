package com.MicroService.MicroServiceTransaction.infrastructure.jpa.adapter;

import com.MicroService.MicroServiceTransaction.domain.spi.IShoppingCartPersistencePort;
import com.MicroService.MicroServiceTransaction.infrastructure.feign.client.ShoppingCartFeignClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShoppingCartFeignAdapter implements IShoppingCartPersistencePort {
    private final ShoppingCartFeignClient shoppingCartFeignClient;

    @Override
    public void deleteProductFromShoppingCart(Long productId) {
        shoppingCartFeignClient.removeProductFromCart(productId);
    }
}
