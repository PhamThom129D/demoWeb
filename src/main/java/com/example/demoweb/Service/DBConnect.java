package com.example.demoweb.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String url = "jdbc:mysql://localhost:3306/quanlyshopbandienthoai";
    private static final String username = "root";
    private static final String password = "1209";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không thể tải lớp trình điều khiển JDBC", e);
        }
    }
}
