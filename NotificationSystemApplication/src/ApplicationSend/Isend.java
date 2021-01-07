package com.example.demo.ApplicationSend;

import com.example.demo.Databases.IDatabase;
import com.example.demo.Templates.NotificationTemplate;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Isend {
    public Boolean Send(int id,ArrayList<String>placeHolders) throws SQLException;
    public IDatabase DB=new IDatabase() {};
    public default  String PreparationToSend(String body, ArrayList<String> placeHolders){
        int idx=0;
        while(body.contains("#")){
            body=body.replaceFirst("#",placeHolders.get(idx++));
        }
        return body;
    }
}
