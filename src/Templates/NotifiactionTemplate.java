package Templates;

public class NotifiactionTemplate {
    private String subject;
    private String body;
    private String language;
    private int id;
    
    public void setLanguage(String language) {
        this.language = language;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getLanguage() {
        return this.language;
    }
    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public int getId() {
        return id;
    }
}
