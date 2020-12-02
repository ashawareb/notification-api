package Operations;

import Templates.NotifiactionTemplate;

public class DatabaseOperations {

    public boolean create(NotifiactionTemplate template){
        //insert into notification_templates(template.subject,template.body,template.id);
        //if(query executed)return true;
        //return false;
        return true;//for now only
    }
    public NotifiactionTemplate read(int id){
        //select from Notification_template the record where id=id;
        NotifiactionTemplate template=new NotifiactionTemplate();
        return template;
    }
    public boolean update(int id,NotifiactionTemplate template){
        // update the record where id=id;
        return true;
    }
    public boolean delete(int id){
        //delete the record where id=id;
        return true;
    }
}
