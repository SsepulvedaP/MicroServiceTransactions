package com.MicroService.MicroServiceTransaction.domain.models;


import java.time.LocalDateTime;

public class Supply {
    private Long id;
    private Long productId;
    private int quantity;
    private LocalDateTime date;

    public Supply(Long id, Long productId, int quantity, LocalDateTime date) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.date = LocalDateTime.now();;
    }

    public Supply() {
        this.date = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime localDateTime) {
        this.date = (date != null) ? date : LocalDateTime.now();
    }
}
