package dtos.Response;

import java.time.LocalDateTime;

public class FindResponse {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private int id;
    private LocalDateTime dateRegistered;

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
        this.emailAddress = firstName+lastName+"@gmail.com";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(LocalDateTime dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    @Override
    public String toString() {
        return "FindResponse{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", id=" + id +
                ", dateRegistered=" + dateRegistered +
                '}';
    }



}
