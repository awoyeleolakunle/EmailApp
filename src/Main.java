import controller.UserController;
import dtos.Request.RegisterRequest;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        letMail();
    }

    private static UserController userController = new UserController();
    private static void letMail(){
    String message = """
           The world is at your finger tip "Mail it"
            1-> RegisterUser
            2->FindUser
            """;
    String input = input(message);
    switch (input.charAt(0)) {
        case '1'-> registerUser();
        case '2'-> findUser();
        default -> {display("Invalid option"); letMail();}
    }

    }

    private static void findUser() {
        String userInput = input("enter your emailAddress");
        display(userController.findUserByEmailAddress(userInput).toString());
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