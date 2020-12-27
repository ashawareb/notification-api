package com.example.demo.Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface IDatabase {
    public default Connection connectToDatabase()throws SQLException{
        String url = "jdbc:mysql://localhost:3306/Notification_System";
        String user = "root";
        String password = "20180184";
        Connection connection = null;
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    };


}
