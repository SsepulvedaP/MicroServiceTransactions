package com.MicroService.MicroServiceTransaction.infrastructure.jpa.repository;

import com.MicroService.MicroServiceTransaction.infrastructure.jpa.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {
    @Query(value = "SELECT date FROM transactions.supply WHERE product_id = :productId ORDER BY date DESC LIMIT 1", nativeQuery = true)
    Optional<LocalDateTime> findLastSupplyDateByProductId(Long productId);
}
