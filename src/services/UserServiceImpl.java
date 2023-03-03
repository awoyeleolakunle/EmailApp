package services;

import data.model.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.Request.RegisterRequest;
import dtos.Response.FindResponse;
import utils.Mapper;

public class UserServiceImpl implements UserService {

        private static UserRepository userRepository = new UserRepositoryImpl();
private User user;
        @Override
        public User registerUser (RegisterRequest request){
            if (isRegistered(request.getId()))
                throw new IllegalArgumentException((request.getEmailAddress() + " " + "has been taken. Try with another combination of names"));
            user = new User();
           Mapper.map(request, user);
          // Mapper.map(request);
            return userRepository.saveUser(user);
        }

        @Override
        public FindResponse findUser(int id){
          User foundUser = userRepository.findUser(id);
            FindResponse response = new FindResponse();
            response.setFirstName(foundUser.getFirstName());
            response.setLastName(foundUser.getLastName());
            response.setId(foundUser.getId());
            response.setEmailAddress(foundUser.getFirstName(), foundUser.getLastName());

            return response;
        }

    @Override
    public FindResponse findUser(String emailAddress) {
        User foundUser = userRepository.findUser(emailAddress);
        FindResponse response = new FindResponse();
        response.setFirstName(foundUser.getFirstName());
        response.setLastName(foundUser.getLastName());
        response.setId(foundUser.getId());
        response.setEmailAddress(foundUser.getFirstName(), foundUser.getLastName());

        return response;
    }

    public boolean isRegistered (int id){
            User foundUser = userRepository.findUser(id);
            if (foundUser != null) return true;
            return false;
        }
    }
