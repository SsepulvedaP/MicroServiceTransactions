package com.MicroService.MicroServiceTransaction.infrastructure.feign.client;

import com.MicroService.MicroServiceTransaction.application.dto.request.StockUpdateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "product-service", url = "${feign.client.product-service.url}")
public interface ProductFeignClient {

    @PatchMapping(value = "/products/updateStock")
    ResponseEntity<Void> updateArticleQuantity(@RequestBody StockUpdateRequest stockUpdateRequest);
}