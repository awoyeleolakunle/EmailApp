package data.repositories;

import data.model.User;

public interface UserRepository {
    User saveUser(User user);
    User findUser(String emailAddress);
    User findUser(int id);
    void deleteUser(String emailAddress);
    void deleteAllUser();
    int count();

}
