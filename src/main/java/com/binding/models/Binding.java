package com.binding.models;

import java.time.LocalDateTime;

public class Binding {
    private int id;
    private String sellerName;
    private String product;
    private LocalDateTime createdAt;
    private Double bidAmount;

    public Binding(int id, String name, String description,LocalDateTime createdAt,Double bidAmount) {
        this.id = id;
        this.sellerName = name;
        this.product = description;
        this.createdAt = createdAt;
        this.bidAmount=bidAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public LocalDateTime  getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime  createdAt) {
        this.createdAt = createdAt;
    }

    public Double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }

    @Override
    public String toString() {
        return "Binding{" +
                "id=" + id +
                ", sellerName='" + sellerName + '\'' +
                ", product='" + product + '\'' +
                ", createdAt=" + createdAt +
                ", bidAmount=" + bidAmount +
                '}';
    }
}
