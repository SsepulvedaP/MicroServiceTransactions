package com.MicroService.MicroServiceTransaction.infrastructure.feign.client;

import com.MicroService.MicroServiceTransaction.application.dto.request.StockUpdateRequest;
import com.MicroService.MicroServiceTransaction.domain.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "product-service", url = "${feign.client.product-service.url}")
public interface ProductFeignClient {

    @PatchMapping(value = "/products/updateStock")
    ResponseEntity<Void> updateArticleQuantity(@RequestBody StockUpdateRequest stockUpdateRequest);


    @PatchMapping(value = "/products/reduceStock")
    ResponseEntity<Void> reduceProductQuantity(@RequestBody StockUpdateRequest stockUpdateRequest);



    @GetMapping("/products/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Long id);

}