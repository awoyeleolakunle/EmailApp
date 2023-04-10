package dtos.Response;

import java.time.LocalDateTime;

public class FindMailResponse {
    private String subject;
    private String body;
    private int id;
    private LocalDateTime dateTime;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String title) {
        this.subject = title;
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
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "FindMailResponse{" +
                "subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", id=" + id +
                ", dateTime=" + dateTime +
                '}';
    }
}
