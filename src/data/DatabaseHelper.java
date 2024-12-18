package data;

import java.sql.*;

public class DatabaseHelper {
    private static final String DATABASE_URL = "jdbc:sqlite:stock.db";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            throw new RuntimeException("Connection to SQLite failed!", e);
        }
    }

    public static void initializeDatabase() {
        String createTableQuery = """
            CREATE TABLE IF NOT EXISTS products (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                quantity INTEGER NOT NULL,
                price REAL NOT NULL,
                shelf_life INTEGER
            );
        """;

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(createTableQuery);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize the database!", e);
        }
    }
}
