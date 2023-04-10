package controller;

import dtos.Request.RegisterRequest;
import services.UserService;
import services.UserServiceImpl;

public class UserController {
    private UserService userService = new UserServiceImpl();

    public Object register(RegisterRequest registerRequest) {
        try{
           return userService.registerUser(registerRequest);
        }
        catch(IllegalArgumentException e){
            return e.getMessage();
        }
    }

    public Object findUserByEmailAddress(String emailAddress){
        try{
        return userService.findUser(emailAddress);
    }
        catch (IllegalArgumentException e){
        return e.getMessage();}
    }
    public boolean userLogin(String emailAddress, String passWord){
        try{
        return userService.isLogin(emailAddress, passWord);
    }
        catch (IllegalArgumentException e){
        return Boolean.parseBoolean(e.getMessage()); }
    }

    public Object inbox(String emailAddress){

        try {
           return userService.userInbox(emailAddress);
            }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }
        public Object outbox(String emailAddress){
        try{
            return userService.userOutBox(emailAddress);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
        }
}
