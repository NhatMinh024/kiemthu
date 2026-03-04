package pt.quanlysinhvien.dao;

import java.sql.*;

/**
 * Database connection manager
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLySinhVien;encrypt=false";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123456";
    
    private static Connection connection;
    
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                throw new SQLException("SQL Server JDBC Driver not found", e);
            }
        }
        return connection;
    }
    
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Tạo database và bảng nếu chưa tồn tại
     */
    public static void initializeDatabase() {
        try (Connection conn = getConnection()) {
            // Tạo bảng SinhVien nếu chưa tồn tại
            String createTableSQL = """
                IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='SinhVien' AND xtype='U')
                CREATE TABLE SinhVien (
                    MaSV varchar(10) PRIMARY KEY,
                    HoTen nvarchar(50) NOT NULL,
                    NgaySinh date,
                    GioiTinh nvarchar(10),
                    DiaChi nvarchar(100),
                    SDT varchar(15),
                    Email varchar(50),
                    Lop nvarchar(20),
                    Khoa nvarchar(50)
                )
                """;
            
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSQL);
                System.out.println("Database initialized successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }
}
