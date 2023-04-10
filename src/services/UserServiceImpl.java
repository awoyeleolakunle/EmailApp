package services;

import data.model.Mail;
import data.model.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.Request.RegisterRequest;
import dtos.Response.FindResponse;
import utils.Mapper;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserRepository userRepository = new UserRepositoryImpl();
    private User user;

    List<Mail> addMail = new ArrayList<>();

    List<Mail> userMailOutbox = new ArrayList<>();

    @Override
    public User registerUser(RegisterRequest request) {
        if (isRegistered(request.getId()))
            throw new IllegalArgumentException((request.getEmailAddress() + " " + "has been taken. Try with another combination of names"));
        user = new User();
        Mapper.map(request, user);
        // Mapper.map(request);
        return userRepository.saveUser(user);
    }

    @Override
    public FindResponse findUser(int id) {
        User foundUser = userRepository.findUser(id);
        FindResponse response = new FindResponse();
        response.setFirstName(foundUser.getFirstName());
        response.setLastName(foundUser.getLastName());
        response.setId(foundUser.getId());
        response.setEmailAddress(foundUser.getFirstName(), foundUser.getLastName());
        response.setDateRegistered(foundUser.getDateTime());

        return response;
    }

    @Override
    public FindResponse findUser(String emailAddress) {
        validate(emailAddress);
        User foundUser = userRepository.findUser(emailAddress);
        FindResponse response = new FindResponse();
        response.setFirstName(foundUser.getFirstName());
        response.setLastName(foundUser.getLastName());
        response.setId(foundUser.getId());
        response.setEmailAddress(foundUser.getFirstName(), foundUser.getLastName());
        response.setDateRegistered(foundUser.getDateTime());


        return response;
    }

    @Override
    public boolean isLogin(String email, String password) {
        validate(email);
        validatePassWord(email, password);
        return true;

    }

    @Override
    public void userInboxMail(String emailAddress, Mail mail) {
        if(emailAddress.equals(findUser(emailAddress).getEmailAddress()))
            user = userRepository.findUser(emailAddress);
        user.setMail(mail);
    }

    @Override
    public void userOutBoxMail( String emailAddress, Mail mail) {
        user = userRepository.findUser(emailAddress);
        user.setOutbox(mail);
    }

    @Override
    public List<Mail> userInbox(String emailAddress) {
        addMail = userRepository.findUser(emailAddress).getInboxMail();
        return addMail;
    }

    @Override
    public List<Mail> userOutBox(String emailAddress) {
       userMailOutbox = userRepository.findUser(emailAddress).getOutboxMail();
        return userMailOutbox;
    }

    public boolean isRegistered(int id) {
        User foundUser = userRepository.findUser(id);
        if (foundUser != null) return true;
        return false;
    }
    private static void validate(String emailAddress){
        if (userRepository.findUser(emailAddress) ==null) throw new IllegalArgumentException("Email does not exist");
    }

    private static void validatePassWord(String emailAddress, String passWord){
        if(!(userRepository.findUser(emailAddress).getPassWord().equals(passWord)))
            throw new IllegalArgumentException("Invalid PassWord");
    }
}
