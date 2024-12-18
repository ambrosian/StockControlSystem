package com.a20210305032.business;

import com.a20210305032.Stockable;

public abstract class Product implements Stockable {
    private int productId;
    private String name;
    private int quantity;
    private double price;

    public Product(int productId, String name, int quantity, double price) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void manageStock(int quantity) {
        setQuantity(getQuantity() + quantity);
    }

    @Override
    public double calculateTotalValue() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + name + ", Quantity: " + quantity + ", Price: $" + String.format("%.2f", price);
    }
}
