package com.example.demo.Templates;

public class NotificationTemplate {
    Language language;
    private String body;
    private String subject;
    private int ID;

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
        return '\"' + this.subject + '\"' + ',' + '\"' + this.body + '\"' + ',' + '\"' + this.language + '\"';
    }
}
