package com.example.librettovoti.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    public static Connection getConnection() throws SQLException {

        String jdbcURL = "jdbc:mariadb://localhost/libretto?user=root&password=root";
        Connection connection = DriverManager.getConnection(jdbcURL);
        return connection;
    }
}
