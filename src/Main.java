package com.a20210305032;

import com.a20210305032.business.Product;
import com.a20210305032.business.PerishableProduct;
import com.a20210305032.business.DigitalProduct;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockManager manager = new StockManager();

        System.out.println("Welcome to the Advanced Stock Control System");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Regular Product");
            System.out.println("2. Add Perishable Product");
            System.out.println("3. Add Digital Product");
            System.out.println("4. View All Products");
            System.out.println("5. Update Stock");
            System.out.println("6. Update Price");
            System.out.println("7. Delete Product");
            System.out.println("8. Filter Products by Name");
            System.out.println("9. View Low Stock Products");
            System.out.println("10. View Total Stock Value");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    manager.addProduct(new Product(manager.getNextId(), name, quantity, price) {});
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    String perishableName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int perishableQuantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double perishablePrice = scanner.nextDouble();
                    System.out.print("Enter shelf life (in days): ");
                    int shelfLife = scanner.nextInt();
                    manager.addProduct(new PerishableProduct(manager.getNextId(), perishableName, perishableQuantity, perishablePrice, shelfLife));
                    break;
                case 3:
                    System.out.print("Enter digital product name: ");
                    String digitalName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int digitalQuantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double digitalPrice = scanner.nextDouble();
                    System.out.print("Enter file size (in MB): ");
                    double fileSize = scanner.nextDouble();
                    manager.addProduct(new DigitalProduct(manager.getNextId(), digitalName, digitalQuantity, digitalPrice, fileSize));
                    break;
                case 4:
                    manager.viewProducts();
                    break;
                case 5:
                    System.out.print("Enter product ID to update stock: ");
                    int productId = scanner.nextInt();
                    System.out.print("Enter quantity to add: ");
                    int qty = scanner.nextInt();
                    manager.updateStock(productId, qty);
                    break;
                case 6:
                    System.out.print("Enter product ID to update price: ");
                    int priceId = scanner.nextInt();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    manager.updatePrice(priceId, newPrice);
                    break;
                case 7:
                    System.out.print("Enter product ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteProduct(deleteId);
                    break;
                case 8:
                    System.out.print("Enter product name to filter: ");
                    String filterName = scanner.nextLine();
                    manager.filterProductsByName(filterName);
                    break;
                case 9:
                    System.out.print("Enter stock threshold: ");
                    int threshold = scanner.nextInt();
                    manager.viewLowStock(threshold);
                    break;
                case 10:
                    manager.viewTotalStockValue();
                    break;
                case 11:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
