package Databases;

import java.sql.*;

public interface database {
    public Connection ConnectToDB() throws SQLException;
    public void executeQuery(String query, Connection connection) throws SQLException;

}

