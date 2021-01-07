package com.example.demo.Operations;

import com.example.demo.Templates.NotificationTemplate;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CRUD {
    public boolean create(NotificationTemplate notification) throws SQLException;

    public ArrayList<NotificationTemplate> read() throws SQLException;

    public boolean update(int id, NotificationTemplate notification) throws SQLException;

    public boolean delete(int id) throws SQLException;

}
