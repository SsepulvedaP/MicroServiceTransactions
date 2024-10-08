package com.MicroService.MicroServiceTransaction.domain.models;

import java.time.LocalDateTime;
import java.util.List;

public class Sale {
    private Long id;
    private Long userId;
    private String userEmail;
    private LocalDateTime purchaseDate;
    private double totalAmount;
    private List<SaleItem> saleItems;
    private String status;

    public Sale(Long id, Long userId, LocalDateTime purchaseDate, double totalAmount, List<SaleItem> saleItems, String status, String userEmail) {
        this.id = id;
        this.userId = userId;
        this.purchaseDate = purchaseDate;
        this.totalAmount = totalAmount;
        this.saleItems = saleItems;
        this.status = status;
        this.userEmail = userEmail;
    }
    public Sale(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<SaleItem> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
