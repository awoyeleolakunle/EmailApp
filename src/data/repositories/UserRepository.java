package data.repositories;

import data.model.Mail;
import data.model.User;

import java.util.List;

public interface UserRepository {
    User saveUser(User user);
    User findUser(String emailAddress);
    User findUser(int id);
    void deleteUser(String emailAddress);
    void deleteAllUser();

    void addToInbox( String emailAddress, Mail mail);

    void addToOutBox(String emailAddress, Mail mail);
    int count();

}
