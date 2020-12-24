package Databases;

import java.sql.*;

public interface IDatabase {
    public Connection connectToDatabase() throws SQLException;

    public boolean executeQuery(String query, Connection connection) throws SQLException;
}
