package com.example.demo.Databases;

import com.example.demo.Operations.CRUD;
import com.example.demo.Templates.Language;
import com.example.demo.Templates.NotificationTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.*;
@Component
@Qualifier("CRUD")
public class MySQLDatabase implements IDatabase, CRUD {

    //Apply Singleton Pattern

    public MySQLDatabase() {
    }


    

    @Override
    public Connection connectToDatabase() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Notification_System";
        String user = "root";
        String password = "Emadtarek563";
        Connection connection = null;
        connection = DriverManager.getConnection(url, user, password);

        return connection;
    }


    @Override
    public boolean create(NotificationTemplate notification) throws SQLException {
        String check = "";
        Connection connection = connectToDatabase();
        Statement stmt = connection.createStatement();
        String sql = "SELECT subject FROM Notification_Templates WHERE id=" + notification.getID();
        ResultSet res = stmt.executeQuery(sql);
        while (res.next()) {
            check += res.getString("subject");
            if (!check.equals("")) {
                System.out.println("There is template exist with the same ID");
                return false;
            }
        }
        String insertStr = notification.toString();
        sql = "INSERT INTO Notification_Templates(subject, body, id, language) VALUES(" + insertStr + ")";
        int check2 = stmt.executeUpdate(sql);
        return check2 > 0;
    }

    @Override
    public NotificationTemplate read(int id) throws SQLException {
        NotificationTemplate ob = new NotificationTemplate();
        Connection connection = connectToDatabase();
        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM Notification_Templates WHERE id=" + id;
        ResultSet res = stmt.executeQuery(sql);
        if(res.next()){
            ob.setSubject(res.getString("subject"));
            ob.setBody(res.getString("body"));
            ob.setLanguage(Language.valueOf(res.getString("language")));
            ob.setID(id);
        }else{
            ob.setBody("Not found");
            ob.setID(404);
        }

        return ob;
    }

    @Override

    public boolean update(int id, NotificationTemplate notification) throws SQLException {
        Connection connection = connectToDatabase();
        PreparedStatement ps = null;
        String sql = "UPDATE Notification_Templates SET subject=?, body=? ,language=? WHERE id=?";
        ps = connection.prepareStatement(sql);
        ps.setString(1, notification.getSubject());
        ps.setString(2, notification.getBody());
        ps.setString(3, notification.getLanguage().toString());
        ps.setInt(4, id);
        int check = ps.executeUpdate();
        return check > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        Connection connection = connectToDatabase();
        Statement stmt = connection.createStatement();
        String sql = "DELETE FROM Notification_Templates WHERE id=" + id;
        int check = stmt.executeUpdate(sql);
        return check > 0;
    }

}
