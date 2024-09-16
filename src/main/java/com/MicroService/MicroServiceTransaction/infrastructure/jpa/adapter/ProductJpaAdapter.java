package com.MicroService.MicroServiceTransaction.infrastructure.jpa.adapter;

import com.MicroService.MicroServiceTransaction.application.dto.request.StockUpdateRequest;
import com.MicroService.MicroServiceTransaction.domain.spi.IProductPersistencePort;
import com.MicroService.MicroServiceTransaction.infrastructure.feign.client.ProductFeignClient;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ProductJpaAdapter implements IProductPersistencePort {

    private final ProductFeignClient productFeignClient;


    @Override
    public void updateProductQuantity(Long productId, int quantity) {
        StockUpdateRequest stockUpdateRequest = StockUpdateRequest.builder()
                .productId(productId)
                .quantity(quantity)
                .build();
            productFeignClient.updateArticleQuantity(stockUpdateRequest);

    }
}
