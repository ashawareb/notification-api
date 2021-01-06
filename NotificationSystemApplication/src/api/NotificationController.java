package com.example.demo.api;

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
    @Override
    @PostMapping("/create")
    public boolean create(@RequestBody  NotificationTemplate notification) throws SQLException {
        return crud.create(notification);
    }

    @Override
    @GetMapping("/read/{id}")
    public NotificationTemplate read(@PathVariable(value="id") int id) throws SQLException {
        return crud.read(id);
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

    @PostMapping("/send/{id}")
    public boolean send(@PathVariable(value = "id")int id,@RequestBody ArrayList<String> placeHolders) throws SQLException {
        /*
            bellow lines for testing only !
        * */
        System.out.println("id = "+id);
        for(int i=0;i<placeHolders.size();i++)
            System.out.println(placeHolders.get(i));
        
        // Call omar's function :)
        return true;
    }

}
