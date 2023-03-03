package dtos.Request;

import java.time.LocalDateTime;

public class ComposeRequest {
    private String subject;
    private String Body;
    private LocalDateTime dateTime;
    private int id;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ComposeRequest{" +
                "subject='" + subject + '\'' +
                ", Body='" + Body + '\'' +
                ", dateTime=" + dateTime +
                ", id=" + id +
                '}';
    }
}
