package com.circle.circle.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Repository {
    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", 
                "postgres", 
                "postgres");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            resultSet = rs;
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}