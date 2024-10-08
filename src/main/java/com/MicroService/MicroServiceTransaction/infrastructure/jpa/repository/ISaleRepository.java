package com.MicroService.MicroServiceTransaction.infrastructure.jpa.repository;

import com.MicroService.MicroServiceTransaction.infrastructure.jpa.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<SaleEntity, Long> {
}
