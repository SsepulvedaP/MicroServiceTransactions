package com.MicroService.MicroServiceTransaction.infrastructure.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "shopping-cart-service", url = "${feign.client.shopping-cart-service.url}")
public interface ShoppingCartFeignClient {

    @DeleteMapping("/shopping-cart/remove-product/{productId}")
    void removeProductFromCart(@PathVariable Long productId);
}
