package main.java.entities;

import java.util.List;

public class Bill {
    private String userId;
    private List<Product> products;
    private double totalAmount;
    private double discountedAmount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscountedAmount() {
        return discountedAmount;
    }

    public void setDiscountedAmount(double discountedAmount) {
        this.discountedAmount = discountedAmount;
    }

    public Bill(String userId, List<Product> products, double totalAmount, double discountedAmount) {
        this.userId = userId;
        this.products = products;
        this.totalAmount = totalAmount;
        this.discountedAmount = discountedAmount;
    }

    // Getters and setters
}
