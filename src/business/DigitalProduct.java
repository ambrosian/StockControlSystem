package com.a20210305032.business;

public class DigitalProduct extends Product {
    private double fileSize;

    public DigitalProduct(int productId, String name, int quantity, double price, double fileSize) {
        super(productId, name, quantity, price);
        this.fileSize = fileSize;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return super.toString() + ", File Size: " + fileSize + " MB";
    }
}
