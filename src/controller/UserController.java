package controller;

import data.model.User;
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
        return userService.findUser(emailAddress);
    }

}
