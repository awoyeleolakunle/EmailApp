package data.model;

import java.time.LocalDateTime;

public class Email {
    private String accountName;
    private String emailAddress;
    private int Id;
    private LocalDateTime dateTime;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Email{" +
                "accountName='" + accountName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", Id=" + Id +
                ", dateTime=" + dateTime +
                '}';
    }
}
