package Databases;

import java.sql.*;

public class MySQL implements database {

    @Override
    public Connection ConnectToDB() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc://localhost:3306/Notification_System", "", "");
        return connection;
        
    }

    @Override
    public void executeQuery(String query, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
    }
    
}