package services;

import data.model.Mail;
import dtos.Request.ComposeRequest;
import dtos.Response.FindMailResponse;

import java.util.List;

public interface MailService {

        FindMailResponse sendMail( String senderEmailAddress, String emailAddress, ComposeRequest composeRequest);

//    Mail sendMail(int id, ComposeRequest composeRequest);

   Mail findMail(int id);
    FindMailResponse findMail(String Title);
    void receiveMail();
    String deleteMail(int id);

    FindMailResponse saveEmail(ComposeRequest composeRequest);

    List<Mail> findAllMails();


}
