package com.a20210305032;

import com.a20210305032.business.Product;
import java.util.*;
import java.util.stream.Collectors;

public class StockManager {
    private Map<Integer, Product> products = new HashMap<>();
    private int nextId = 1;

    public int getNextId() {
        return nextId++;
    }

    public <T extends Product> void addProduct(T product) {
        products.put(product.getProductId(), product);
        System.out.println("Product added: " + product);
    }

    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in stock.");
        } else {
            products.values().forEach(System.out::println);
        }
    }

    public void updateStock(int productId, int quantity) {
        Product product = products.get(productId);
        if (product != null) {
            product.manageStock(quantity);
            System.out.println("Updated stock: " + product);
        } else {
            System.out.println("Product ID not found.");
        }
    }

    public void updatePrice(int productId, double newPrice) {
        Product product = products.get(productId);
        if (product != null) {
            product.setPrice(newPrice);
            System.out.println("Updated price: " + product);
        } else {
            System.out.println("Product ID not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (products.remove(productId) != null) {
            System.out.println("Product ID " + productId + " has been removed.");
        } else {
            System.out.println("Product ID not found.");
        }
    }

    public void filterProductsByName(String name) {
        List<Product> filteredProducts = products.values().stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        if (filteredProducts.isEmpty()) {
            System.out.println("No products found with name: " + name);
        } else {
            filteredProducts.forEach(System.out::println);
        }
    }

    public void viewLowStock(int threshold) {
        List<Product> lowStockProducts = products.values().stream()
                .filter(product -> product.getQuantity() < threshold)
                .collect(Collectors.toList());

        if (lowStockProducts.isEmpty()) {
            System.out.println("No products with low stock below threshold: " + threshold);
        } else {
            System.out.println("Products with low stock:");
            lowStockProducts.forEach(System.out::println);
        }
    }

    public void viewTotalStockValue() {
        double totalValue = products.values().stream()
                .mapToDouble(Product::calculateTotalValue)
                .sum();
        System.out.println("Total stock value: $" + String.format("%.2f", totalValue));
    }
}
