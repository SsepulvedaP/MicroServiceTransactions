package com.MicroService.MicroServiceTransaction.infrastructure.jpa.adapter;

import com.MicroService.MicroServiceTransaction.application.dto.request.StockUpdateRequest;
import com.MicroService.MicroServiceTransaction.domain.models.Product;
import com.MicroService.MicroServiceTransaction.domain.spi.IProductPersistencePort;
import com.MicroService.MicroServiceTransaction.infrastructure.feign.client.ProductFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;


@RequiredArgsConstructor
public class ProductJpaAdapter implements IProductPersistencePort {

    private final ProductFeignClient productFeignClient;


    @Override
    public void updateProductQuantity(Long productId, int quantity) {
        StockUpdateRequest stockUpdateRequest = StockUpdateRequest.builder()
                .productId(productId)
                .quantity(quantity)
                .build();
            productFeignClient.reduceProductQuantity(stockUpdateRequest);

    }

    @Override
    public Product getProductById(Long productId) {
        ResponseEntity<Product> product = productFeignClient.getProductById(productId);
        return product.getBody();
    }

    @Override
    public void reduceProductQuantity(Long productId, int quantity) {
        StockUpdateRequest stockUpdateRequest = StockUpdateRequest.builder()
                .productId(productId)
                .quantity(quantity)
                .build();
        productFeignClient.reduceProductQuantity(stockUpdateRequest);
    }
}
