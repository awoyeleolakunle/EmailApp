package services;

import data.model.User;
import dtos.Request.RegisterRequest;
import dtos.Response.FindResponse;

public interface UserService {
    User registerUser(RegisterRequest request );

    FindResponse findUser(int id);

    FindResponse findUser(String emailAddress);

}
