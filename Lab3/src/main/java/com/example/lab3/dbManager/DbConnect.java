package com.example.lab3.dbManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect
{
    public static Connection getConnection()
    {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/university?useSSL=false", "postgres", "12345");
        }
        catch(SQLException e)
        {
            System.out.println("Failed to connect");
        }
        return connection;
    }
}
