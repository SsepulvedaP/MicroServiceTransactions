package com.MicroService.MicroServiceTransaction.application.handler;


import com.MicroService.MicroServiceTransaction.application.dto.request.SaleRequest;
import com.MicroService.MicroServiceTransaction.application.dto.response.SaleResponse;
import com.MicroService.MicroServiceTransaction.application.mapper.SaleMapper;
import com.MicroService.MicroServiceTransaction.domain.api.ISaleServicePort;
import com.MicroService.MicroServiceTransaction.domain.models.Sale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SaleHandler implements ISaleHandler {

    private final ISaleServicePort saleServicePort;
    private final SaleMapper saleMapper;

    @Override
    public SaleResponse createSale(SaleRequest saleRequest, Long userId, String userEmail, String token) {
        Sale sale = saleMapper.toSale(saleRequest);
        Sale createdSale = saleServicePort.createSale(sale, userId, userEmail, token);
        return saleMapper.toSaleResponse(createdSale);
    }
}
