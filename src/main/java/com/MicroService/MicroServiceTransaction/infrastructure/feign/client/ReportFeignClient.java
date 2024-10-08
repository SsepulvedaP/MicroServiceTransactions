package com.MicroService.MicroServiceTransaction.infrastructure.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import com.MicroService.MicroServiceTransaction.application.dto.request.ReportRequest;

@FeignClient(name = "report-service", url = "${feign.client.report-service.url}")
public interface ReportFeignClient {
    @PostMapping("/reports/create")
    ResponseEntity<Void> createPurchaseReport(@RequestBody ReportRequest reportRequest);
}
