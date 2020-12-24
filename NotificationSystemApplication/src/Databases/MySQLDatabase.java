package Databases;

import Operations.CRUD;
import Templates.NotificationTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabase implements IDatabase, CRUD {

    //Apply Singleton Pattern
    private static MySQLDatabase obj;

    private MySQLDatabase() {
    }

    public static synchronized MySQLDatabase GlobalObject() {
        if (obj == null) {
            obj = new MySQLDatabase();
        }
        return obj;
    }

    @Override
    public Connection connectToDatabase() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Notification_System";
        String user = "root";
        String password = "";
        Connection connection = null;
        connection = DriverManager.getConnection(url, user, password);
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection = null;
            //String url = "jdbc:mysql://localhost:3306/Notification_System";
            connection = DriverManager.getConnection(url, "root", "");
            //System.out.println("YARRRRRRRRRRRRRRRAB");
            return connection;
        } catch (Exception e) {
            System.out.print(e);
        }*/
        return connection;
    }

    @Override
    public boolean executeQuery(String query, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean create(NotificationTemplate notification) {
        return false;
    }

    @Override
    public NotificationTemplate read(int id) {
        return null;
    }

    @Override
    public boolean update(int id, NotificationTemplate notification) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public NotificationTemplate search(int id) {
        return null;
    }
}
