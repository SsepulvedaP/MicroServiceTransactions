package com.MicroService.MicroServiceTransaction.infrastructure.jpa.adapter;

import com.MicroService.MicroServiceTransaction.domain.models.Supply;
import com.MicroService.MicroServiceTransaction.domain.spi.ISupplyPersistencePort;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.entity.SupplyEntity;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.mapper.SupplyEntityMapper;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SupplyJpaAdapter implements ISupplyPersistencePort {

    private final ISupplyRepository supplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;

    @Override
    public void saveSupply(Supply supply) {
        SupplyEntity supplyEntity = supplyEntityMapper.toSupplyEntity(supply);
        supplyRepository.save(supplyEntity);

    }
}
