package data;

import com.a20210305032.business.Product;
import com.a20210305032.business.PerishableProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public void addProduct(Product product) {
        String insertQuery = "INSERT INTO products (name, quantity, price, shelf_life) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseHelper.connect(); PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getQuantity());
            pstmt.setDouble(3, product.getPrice());
            if (product instanceof PerishableProduct perishable) {
                pstmt.setInt(4, perishable.getShelfLife());
            } else {
                pstmt.setNull(4, Types.INTEGER);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add product to database!", e);
        }
    }

    public List<Product> getAllProducts() {
        String selectQuery = "SELECT * FROM products";
        List<Product> products = new ArrayList<>();

        try (Connection conn = DatabaseHelper.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(selectQuery)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                Integer shelfLife = rs.getObject("shelf_life", Integer.class);

                if (shelfLife != null) {
                    products.add(new PerishableProduct(id, name, quantity, price, shelfLife));
                } else {
                    products.add(new Product(id, name, quantity, price) {});
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve products from database!", e);
        }

        return products;
    }
}
