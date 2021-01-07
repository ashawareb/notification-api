package com.example.demo.api;

import com.example.demo.ApplicationSend.Isend;
import com.example.demo.ApplicationSend.Mail;
import com.example.demo.ApplicationSend.SMS;
import com.example.demo.Databases.MySQLDatabase;
import com.example.demo.Operations.CRUD;
import com.example.demo.Templates.NotificationTemplate;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/notification")
public class NotificationController implements CRUD {
    @Autowired
    @Qualifier("CRUD")
    CRUD crud =new MySQLDatabase();
    Isend mail;
    @Override
    @PostMapping("/create")
    public boolean create(@RequestBody  NotificationTemplate notification) throws SQLException {
        return crud.create(notification);
    }

    @Override
    @GetMapping("/read")
    public ArrayList<NotificationTemplate> read() throws SQLException {
        return crud.read();
    }
    @Override
    @PutMapping(value = "update/{id}")
    public boolean update(@PathVariable(value = "id")int id,@RequestBody NotificationTemplate notification) throws SQLException {
        return crud.update(id,notification);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable(value = "id")int id) throws SQLException {
        return crud.delete(id);
    }

    @PostMapping("/sendMail/{id}")
    public boolean sendMail(@PathVariable(value = "id")int id,@RequestBody ArrayList<String> placeHolders) throws SQLException {
        mail=new Mail();
        /*
            bellow lines for testing only !
        * */
        System.out.println("id = "+id);
        for(int i=0;i<placeHolders.size();i++)
            System.out.println(placeHolders.get(i));

        // Call omar's function :)
        return mail.Send(id,placeHolders);
    }
    @PostMapping("/sendSMS/{id}")
    public boolean sendSMS(@PathVariable(value = "id")int id,@RequestBody ArrayList<String> placeHolders) throws SQLException {
        mail=new SMS();
        /*
            bellow lines for testing only !
        * */
        System.out.println("id = "+id);
        for(int i=0;i<placeHolders.size();i++)
            System.out.println(placeHolders.get(i));

        // Call omar's function :)
        return mail.Send(id,placeHolders);
    }
}
