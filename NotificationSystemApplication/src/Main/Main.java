package com.example.demo.Main;

import com.example.demo.Databases.IDatabase;
import com.example.demo.Databases.MySQLDatabase;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        IDatabase DB=new MySQLDatabase();
        Connection myConn = DB.connectToDatabase();
        System.out.println();
        System.out.println();
        if (myConn == null) {
            System.out.println("NULL");
        } else {
            System.out.println("CONNECTED");
        }
    }
}
