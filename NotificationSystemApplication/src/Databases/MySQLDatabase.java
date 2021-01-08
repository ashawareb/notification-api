package com.example.demo.Databases;

import com.example.demo.Operations.CRUD;
import com.example.demo.Templates.Language;
import com.example.demo.Templates.NotificationTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
@Qualifier("CRUD")
public class MySQLDatabase implements IDatabase, CRUD {

    public MySQLDatabase() {
    }


    @Override
    public boolean create(NotificationTemplate notification) throws SQLException {
        Connection connection = connectToDatabase();
        Statement stmt = connection.createStatement();
        String insertStr = notification.toString();
        String sql = "INSERT INTO Notification_Templates(subject, body, language) VALUES(" + insertStr + ")";
        System.out.println(insertStr+"\n"+sql);
        int check2 = stmt.executeUpdate(sql);
        return check2 > 0;
    }

    @Override
    public ArrayList<NotificationTemplate> read() throws SQLException {
        ArrayList<NotificationTemplate> temps = new ArrayList<>();
        Connection connection = connectToDatabase();
        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM Notification_Templates";
        ResultSet res = stmt.executeQuery(sql);
        while (res.next()) {
            NotificationTemplate ob=new NotificationTemplate();
            ob.setSubject(res.getString("subject"));
            ob.setBody(res.getString("body"));
            ob.setLanguage(Language.valueOf(res.getString("language")));
            ob.setID(res.getInt("id"));
            temps.add(ob);
        }
        return temps;
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
