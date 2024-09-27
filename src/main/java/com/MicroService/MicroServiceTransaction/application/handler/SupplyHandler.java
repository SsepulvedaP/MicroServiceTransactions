package com.MicroService.MicroServiceTransaction.application.handler;

import com.MicroService.MicroServiceTransaction.application.dto.request.SupplyRequest;
import com.MicroService.MicroServiceTransaction.application.mapper.SupplyRequestMapper;
import com.MicroService.MicroServiceTransaction.domain.api.ISupplyServicePort;
import com.MicroService.MicroServiceTransaction.domain.models.Supply;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
@Transactional
@RequiredArgsConstructor
public class SupplyHandler implements ISupplyHandler {

    private final ISupplyServicePort supplyServicePort;
    private final SupplyRequestMapper supplyRequestMapper;

    @Override
    public void saveSupply(SupplyRequest supplyRequest, Long userId, String token) {
        Supply supply = supplyRequestMapper.ToSupply(supplyRequest);
        supply.setId(userId);

        supply.setDate(LocalDateTime.now());
        supplyServicePort.saveSupply(supply, token);
    }

    @Override
    public LocalDateTime nextSupplyDate(Long productId) {
        return supplyServicePort.nextSupplyDate(productId);
    }

}
