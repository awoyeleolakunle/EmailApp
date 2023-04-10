package controller;

import dtos.Request.ComposeRequest;
import services.MailService;
import services.MailServiceImpl;

public class MailController {
    private MailService mailService = new MailServiceImpl();

    public Object sendMail( String senderEmailAddress, String email, ComposeRequest composeRequest) {
        try {
            return mailService.sendMail(senderEmailAddress, email,  composeRequest);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public Object checkInbox() {
        try {
            return mailService.findAllMails();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public Object deleteMailById(int id) {
        try {
            return mailService.deleteMail(id);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

//    public Object UserInbox() {
//        try {
//            return mailService.findUserAllMail();
//        } catch (IllegalArgumentException e) {
//            return e.getMessage();
//        }getMessage

    public Object deleteMail(int id){
        try{
            return mailService.deleteMail(id);
        }
        catch (IndexOutOfBoundsException e){
          return "Mail not found";
        }
    }
}
