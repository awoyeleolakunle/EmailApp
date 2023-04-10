import controller.MailController;
import controller.UserController;
import dtos.Request.ComposeRequest;
import dtos.Request.RegisterRequest;

import javax.swing.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        letMail();
    }

    private static UserController userController = new UserController();
    private static MailController mailController = new MailController();
    private static LocalDateTime dateTime = LocalDateTime.now();

    private static void letMail() {
        String message = """
                The world is at your finger tip "Mail it"
                 1-> Register User
                 2-> Find User
                 3-> Login
                 4-> Exit Application
                 """;
        String input = input(message);
        switch (input.charAt(0)) {
            case '1' -> registerUser();
            case '2' -> findUser();
            case '3' -> login();
            case '4'-> System.exit(0);
        }

    }


    private static void login() {
        String emailAddress = input("enter your emailAddress");
        String password = input("enter your password");
       if(userController.userLogin(emailAddress, password))
        afterLogin();
       else { display("invalid details");
       letMail();}

    }



    private static void afterLogin() {
                String menu = """
                        1-> SendMail
                        2-> Inbox
                        3-> Outbox
                        4-> deleteEmail
                        5-> logOut
                           """;
                String userInput = input(menu);
                switch (userInput.charAt(0)) {
                    case '1' -> sendMail();
                    case '2' -> { String email = input("please enter your emailAddress to check your inbox ");
                        Inbox(email);}
                    case '3' -> {String email = input("please enter your emailAddress to check your outbox ");
                        outBox(email);}
                    case '4' -> deleteMail();
                    case '5' -> logOut();
                    default -> {
                        display("Invalid option");
                        afterLogin();
                    }
                }
            }

    private static void outBox(String emailAddress) {
       var outBox = userController.outbox(emailAddress);
       display(outBox.toString());
       afterLogin();
    }

    private static void deleteMail() {
        int id = Integer.parseInt(input("enter the mail Id"));
        mailController.deleteMail(id);
        afterLogin();
    }
    private static void logOut() {
        letMail();
    }


//    private static void userInbox() {
//        display(mailController.UserInbox().toString());
//        afterLogin();
//    }

    private static void Inbox(String emailAddress) {
        var inbox = userController.inbox(emailAddress);
        display(inbox.toString());
        afterLogin();
    }

    private static void sendMail() {
        String senderEmailAddress = input("please enter your emailAddress");
        String recipientEmailAddress = input("please enter the recipient emailAddress");
        ComposeRequest composeRequest = new ComposeRequest();
        composeRequest.setSubject(input(" Enter mail subject"));
        composeRequest.setBody(input(" Compose message"));
        composeRequest.setDateTime(dateTime);

        var sendMail = mailController.sendMail( senderEmailAddress, recipientEmailAddress, composeRequest);
        display(sendMail.toString());
        afterLogin();
    }

    private static void findUser() {
        String userInput = input("enter your emailAddress");
        display(userController.findUserByEmailAddress(userInput).toString());
        letMail();
    }

    private static void registerUser() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName(input("Enter your firstName"));
        registerRequest.setLastName(input("Enter your lastName"));
        registerRequest.setPassword(input("create a new password"));

        var newUser = userController.register(registerRequest);
        display(newUser.toString());
        letMail();
    }

    private static String input(String prompt){
        return JOptionPane.showInputDialog(prompt);
}
private static void display(String message){
        JOptionPane.showMessageDialog(null,message);
}
}