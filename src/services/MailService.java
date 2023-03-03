package services;

import data.model.Mail;
import dtos.Request.ComposeRequest;

public interface MailService {

    Mail sendMail(String emailAddress, ComposeRequest composeRequest);

    Mail sendMail(int id, ComposeRequest composeRequest);

    Mail findMail(int id);
    Mail findMail(String Title);
    void receiveMail();
    void deleteMail(int id);

    Mail saveEmail(ComposeRequest composeRequest);
}
