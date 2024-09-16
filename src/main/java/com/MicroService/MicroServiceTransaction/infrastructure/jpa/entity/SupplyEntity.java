package com.MicroService.MicroServiceTransaction.infrastructure.jpa.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "supply")
public class SupplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "productId", nullable = false)
    private Long productId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
    }
}
