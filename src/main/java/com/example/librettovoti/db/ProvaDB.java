package com.example.librettovoti.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvaDB {

    public static void main(String[] args) throws SQLException {

        String jdbcURL = "jdbc:mariadb://localhost/libretto?user=root&password=root";
        String query = "SELECT * FROM voto";

        Connection connection = DriverManager.getConnection(jdbcURL);

        ResultSet rs = connection.prepareStatement(query).executeQuery();
        System.out.println("Nome Corso"+ " - " + "Voto" + " - " + "Data\n");
        while(rs.next()){
            System.out.println(rs.getString("nome_corso") + " - " + rs.getInt("voto") + " - " + rs.getDate("data"));
        }


    }
}
