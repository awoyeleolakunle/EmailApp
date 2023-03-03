package data.repositories;

import data.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {

    private UserRepository userRepository;
    private User user;

    @org.junit.jupiter.api.BeforeEach

    void setUp() {
        userRepository = new UserRepositoryImpl();
         user = new User();
    }
    @Test

    public void saveOneUserTest(){
        userRepository.saveUser(user);
        assertEquals(1, userRepository.count());
    }

    @Test

    public void findUserByEmailAddressTest(){
     userRepository.saveUser(user);
     user.setEmailAddress("Chibuzo","semicolon");
        System.out.println(userRepository.findUser("Chibuzosemicolon@gmail.com"));
     assertEquals(user, userRepository.findUser("Chibuzosemicolon@gmail.com"));
    }
    @Test
    public void userCanBeDeletedByEmailAddress(){
        User newUser = new User();
        userRepository.saveUser(user);
        user.setEmailAddress("Chibuzo","semicolon");
        userRepository.saveUser(newUser);
        newUser.setEmailAddress("Hafeez","Afolabi");
        userRepository.deleteUser("HafeezAfolabi@gmail.com");
        assertEquals(1,userRepository.count());
    }
    @Test

    public void userWithSameEmailAddress(){

        User newUser = userRepository.saveUser(user);
        newUser.setEmailAddress("Chibuzo","semicolon");
        userRepository.saveUser(user);
        user.setEmailAddress("Chibuzo","semicolon");
        userRepository.saveUser(newUser);

        //assertEquals("Chibuzo@gmail.com", userRepository.findUser("Chibuzo@gmail.com").getEmailAddress());
        assertEquals(1, userRepository.count());

    }
    @Test

    public void allUsersCanBeDeletedTest(){
        userRepository.saveUser(user);
        User newUser = new User();
        userRepository.saveUser(newUser);
        assertEquals(2, userRepository.count());
        userRepository.deleteAllUser();
        assertEquals(0,userRepository.count());
    }
}