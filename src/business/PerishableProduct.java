package com.a20210305032.business;

public class PerishableProduct extends Product {
    private int shelfLife;

    public PerishableProduct(int productId, String name, int quantity, double price, int shelfLife) {
        super(productId, name, quantity, price);
        this.shelfLife = shelfLife;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    @Override
    public String toString() {
        return super.toString() + ", Shelf Life: " + shelfLife + " days";
    }
}
