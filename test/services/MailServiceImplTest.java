package services;

import data.model.Mail;
import data.model.User;
import data.repositories.MailRepository;
import data.repositories.MailRepositoryImpl;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.Request.ComposeRequest;
import dtos.Request.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailServiceImplTest {

    private MailRepository mailRepository;
    private  UserRepository userRepository;
    private User user;
    private UserService userService;
    private  Mail mail;
    MailService mailService;
    @BeforeEach
    void setUp() {
        mailRepository = new MailRepositoryImpl();

        user = new User();
        mail = new Mail();
        mailService = new MailServiceImpl();
        userRepository = new UserRepositoryImpl();
        userService = new UserServiceImpl();
    }
    @Test

    public void emailCanBeSentTest(){

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("firstName");
        registerRequest.setLastName("lastName");
        registerRequest.setPassword("password");
        registerRequest.setEmailAddress("firstName", "lastName");
        userService.registerUser(registerRequest);
        userRepository.saveUser(user);
        user.setFirstName(registerRequest.getFirstName());
        user.setPassWord(registerRequest.getPassword());
        user.setLastName(registerRequest.getLastName());
        user.setEmailAddress(registerRequest.getFirstName(), registerRequest.getLastName());
        assertEquals(1,userRepository.count());
        System.out.println(registerRequest.getFirstName());
        System.out.println(user.toString());
        System.out.println(userRepository.saveUser(user).getEmailAddress());
        System.out.println(userService.findUser("firstNamelastName@gmail.com").toString());
        assertEquals("firstNamelastName@gmail.com", userService.findUser("firstNamelastName@gmail.com").getEmailAddress() );
        ComposeRequest composeRequest= new ComposeRequest();
        composeRequest.setSubject("title");
        composeRequest.setBody("body");
        composeRequest.setId(1);
        mail.setBody(composeRequest.getBody());
        mail.setId(composeRequest.getId());
        mail.setSubject(composeRequest.getSubject());
        mailService.saveEmail(composeRequest);
        System.out.println(mailService.saveEmail(composeRequest) + " " + " I'm here");
        //System.out.println(userService.findUser("firstNamelastName@gmail.com"));
        System.out.println(mailService.findMail("title"));
        mailService.sendMail("firstNamelastName@gmail.com", composeRequest);
        System.out.println(composeRequest);

       assertEquals("title" ,mailService.findMail("title").getSubject());
    }
}