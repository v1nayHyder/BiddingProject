package com.binding.models;

public class BuyerBid {
    private int id;
    private String buyerName;
    private  String product;
    private Double bidAmount;
    public BuyerBid(int id, String name,String product, Double bidAmount) {
        this.id = id;
        this.buyerName = name;
        this.product=product;
        this.bidAmount = bidAmount;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }

    @Override
    public String toString() {
        return "BuyerBid{" +
                "id=" + id +
                ", buyerName='" + buyerName + '\'' +
                ", product='" + product + '\'' +
                ", bidAmount=" + bidAmount +
                '}';
    }
}
