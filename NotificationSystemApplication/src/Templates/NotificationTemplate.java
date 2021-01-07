package com.example.demo.Templates;

public class NotificationTemplate {
    Language language;
    private String body;
    private String subject;
    private static int count = 0;
    private int ID;

    public NotificationTemplate() {
        count++;
        this.ID = count;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String toString() {
        return '\"' + this.body + '\"' + ',' + '\"' + this.subject + '\"' + ',' + this.getID() + ',' + '\"' + this.language + '\"';
    }
}
