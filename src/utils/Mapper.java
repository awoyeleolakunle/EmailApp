package utils;

import data.model.User;
import dtos.Request.RegisterRequest;

public class Mapper {
   public static User map(RegisterRequest registerRequest){
        User user = new User();
        user.setEmailAddress(registerRequest.getFirstName(),registerRequest.getLastName());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
      user.setPassWord(registerRequest.getPassword());

        return user;
   }

    public static void map(RegisterRequest registerRequest, User user){
        user.setEmailAddress(registerRequest.getFirstName(), registerRequest.getLastName());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setPassWord(registerRequest.getPassword());

    }

}
