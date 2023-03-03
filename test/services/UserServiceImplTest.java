package services;

import data.model.User;
import dtos.Request.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private UserService userService;
    private User user;
    private RegisterRequest registerRequest = new RegisterRequest();


    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
       User user = new User();
        registerRequest.setFirstName("firstName");
        registerRequest.setLastName("lastName");
        registerRequest.setPassword("passWord");
        registerRequest.setEmailAddress("firstName","lastName");

    }
    @Test
    public void userEmailIsNotNullTest(){
          user = userService.registerUser(registerRequest);

        assertTrue(user.getEmailAddress()!=null);
    }
    @Test

    public void duplicateEmailAddressThrowsExceptionTest(){
       user=  userService.registerUser(registerRequest);
        RegisterRequest newRequest = new RegisterRequest();
        userService.registerUser(newRequest);
        newRequest.setFirstName("firstName");
        newRequest.setLastName("lastName");
        newRequest.setPassword("password");
        newRequest.setId(1);
        newRequest.setEmailAddress("firstName", "lastName");

        System.out.println(newRequest.getEmailAddress());
        System.out.println(user.getEmailAddress());
        assertThrows(IllegalArgumentException.class,()-> userService.registerUser(newRequest));

    }
    @Test
    public void findUserByEmailAddress(){
        user = userService.registerUser(registerRequest);

        assertEquals(user.getEmailAddress(), userService.findUser(1).getEmailAddress());

    }
}