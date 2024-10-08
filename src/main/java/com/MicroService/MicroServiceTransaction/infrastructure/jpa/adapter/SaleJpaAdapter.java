package com.MicroService.MicroServiceTransaction.infrastructure.jpa.adapter;

import com.MicroService.MicroServiceTransaction.domain.models.Sale;
import com.MicroService.MicroServiceTransaction.domain.spi.ISalePersistencePort;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.entity.SaleEntity;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.entity.SaleItemEntity;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.mapper.SaleEntityMapper;
import com.MicroService.MicroServiceTransaction.infrastructure.jpa.repository.ISaleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaleJpaAdapter implements ISalePersistencePort {
    private final ISaleRepository saleRepository;
    private final SaleEntityMapper saleEntityMapper;

    @Override
    public Sale createSale(Sale sale) {
        SaleEntity saleEntity = saleEntityMapper.toEntity(sale);

        // Asignar la entidad sale a cada saleItem
        if (saleEntity.getSaleItems() != null) {
            for (SaleItemEntity saleItem : saleEntity.getSaleItems()) {
                saleItem.setSale(saleEntity);  // Establecer la relación bidireccional
            }
        }

        SaleEntity savedEntity = saleRepository.save(saleEntity);
        return saleEntityMapper.toDomain(savedEntity);
    }

    @Override
    public void updateSale(Sale sale) {
        SaleEntity saleEntity = saleEntityMapper.toEntity(sale);
        saleRepository.save(saleEntity);
    }

}
