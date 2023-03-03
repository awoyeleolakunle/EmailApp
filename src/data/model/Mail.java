package data.model;

import java.time.LocalDateTime;

public class Mail {
    private String Subject;
    private String body;
    private int id;
    private LocalDateTime dateTimeCreated;

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTimeCreated;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTimeCreated = dateTime;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "Subject='" + Subject + '\'' +
                ", body='" + body + '\'' +
                ", id=" + id +
                ", dateTimeCreated=" + dateTimeCreated +
                '}';
    }
}
