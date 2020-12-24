package Operations;

import Templates.NotificationTemplate;

public interface CRUD {
    public boolean create(NotificationTemplate notification);

    public NotificationTemplate read(int id);

    public boolean update(int id, NotificationTemplate notification);

    public boolean delete(int id);

    public NotificationTemplate search(int id);


}
