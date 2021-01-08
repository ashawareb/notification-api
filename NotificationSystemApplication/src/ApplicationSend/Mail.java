package com.example.demo.ApplicationSend;

import com.example.demo.Databases.IDatabase;
import com.example.demo.Templates.NotificationTemplate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

public class Mail implements Isend{
    @Override
    public Boolean Send(int id, ArrayList<String> placeHolders) throws SQLException {
        Connection connection = DB.connectToDatabase();
        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM Notification_Templates WHERE id = "+id;
        ResultSet res = stmt.executeQuery(sql);
        if(!res.next()){
            return false;
        }
        int rand= (int) (Math.random()%2);
        String body=PreparationToSend(res.getString("body"),placeHolders);
        sql = "INSERT INTO mail values("+"\""+body+"\""+ ",\""+res.getString("subject")+
                "\",\""+id+"\",\""+res.getString("language") +"\","
                +"\""+placeHolders.get(placeHolders.size()-1)+"\","+"\""+placeHolders.get(0)+"\","+ rand+')';
        int in = stmt.executeUpdate(sql);
        return rand>0;
    }
}
