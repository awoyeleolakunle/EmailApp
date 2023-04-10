package data.repositories;

import data.model.Mail;
import data.model.User;
import dtos.Request.RegisterRequest;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{

    private int count;
    private List<User>users = new ArrayList<>();

    private List<Mail> mails = new ArrayList<>();

RegisterRequest registerRequest= new RegisterRequest();

    @Override
    public User saveUser(User user) {
        boolean hasNotBeenRegistered = user.getId()==0;
        if (hasNotBeenRegistered){
            user.setId(generateId());
            users.add(user);
                count++;}
        return user;
    }

    private int generateId() {
        return count+1;
    }

    @Override
    public User findUser(String emailAddress) {
        for (User user : users ) {
            if ((user.getEmailAddress().equals(emailAddress))){
                return user;
            }
        }return null;
    }

    @Override
    public User findUser(int id) {
        for (User user : users) {
            if ((user.getId() == id)) {
                return user;
            }
        }return null;
    }

    @Override
    public void deleteUser(String emailAddress) {
        for (User user : users) {
            if(user.getEmailAddress().equals(emailAddress)){
                users.remove(user);
                count--;
                break;
            }
        }

    }

    @Override
    public void deleteAllUser() {

        users.removeAll(users);
        count = users.size();

    }

    @Override
    public void addToInbox( String emailAddress, Mail mail) {
        for (User user: users) {
            if(user.getEmailAddress().equals(emailAddress))
                user.setMail(mail);
        }

    }

    @Override
    public void addToOutBox(String emailAddress, Mail mail) {

    }


    @Override
    public int count() {
        return count ;
    }
}
