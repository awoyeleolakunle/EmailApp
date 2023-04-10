package services;

import data.model.Mail;
import data.model.User;
import dtos.Request.RegisterRequest;
import dtos.Response.FindResponse;

import java.util.List;

public interface UserService {
    User registerUser(RegisterRequest request );

    FindResponse findUser(int id);

    FindResponse findUser(String emailAddress);

    boolean isLogin(String email, String password);

    void userInboxMail(String emailAddress, Mail mail);

    void userOutBoxMail( String emailAddress, Mail mail);

    List<Mail> userInbox(String emailAddress);

    List<Mail> userOutBox(String emailAddress);
}
