package data.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
  private String firstName;
    private String lastName;
    private String emailAddress;
    private String passWord;
    private int id;
    private LocalDateTime dateTime = LocalDateTime.now();

   // private static SecureRandom randomNumber = new SecureRandom();
    private Mail mail;

    private Mail outbox;


    private List<Mail> inboxMail = new ArrayList<>();

    private List<Mail> outboxMail = new ArrayList<>();




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

    public String getFirstName() {
        return firstName;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String firstName, String lastName) {
       // int number = randomNumber.nextInt(11,20);
        this.emailAddress = firstName+lastName+"@gmail.com";
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
        inboxMail.add(mail);
    }

    public List<Mail> getInboxMail() {
        return inboxMail;
    }

    public Mail getOutbox() {
        return outbox;
    }

    public void setOutbox(Mail outbox) {
        this.outbox = outbox;
        outboxMail.add(outbox);
    }


    public List<Mail> getOutboxMail(){
        return outboxMail;
    }

//    public void setInboxMail(List<Mail> inboxMail) {
//        this.inboxMail = inboxMail;
//    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", passWord='" + passWord + '\'' +
                ", id=" + id +
                ", dateTime=" + dateTime +
                '}';
    }
}
