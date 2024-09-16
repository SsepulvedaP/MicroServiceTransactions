package com.MicroService.MicroServiceTransaction.infrastructure.jpa.repository;

import com.MicroService.MicroServiceTransaction.infrastructure.jpa.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {
}
