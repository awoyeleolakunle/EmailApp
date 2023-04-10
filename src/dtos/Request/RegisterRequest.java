package dtos.Request;

public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String emailAddress;
    private int id;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmailAddress(){ return emailAddress;}

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "firstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", id=" + id +
                '}';
    }
}
