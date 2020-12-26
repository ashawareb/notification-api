package com.example.demo.Databases;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDatabase {
    public Connection connectToDatabase() throws SQLException;

}
