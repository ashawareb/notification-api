package com.example.demo.ApplicationSend;

import com.example.demo.Databases.IDatabase;
import com.example.demo.Templates.NotificationTemplate;

import java.sql.SQLException;

public interface Isend {
    public Boolean Send(NotificationTemplate notification,String sender,String receiver) throws SQLException;
    public IDatabase DB=new IDatabase() {};
}
