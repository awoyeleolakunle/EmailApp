package utils;

import data.model.Mail;
import dtos.Request.ComposeRequest;

public class MailMapper {
    public static Mail map(ComposeRequest composeRequest){
        Mail mail = new Mail();
        mail.setSubject(composeRequest.getSubject());
        mail.setBody(composeRequest.getBody());
        mail.setDateTime(composeRequest.getDateTime());
        return mail;

    }

    public static void map(ComposeRequest composeRequest, Mail mail){
        mail.setSubject(composeRequest.getSubject());
        mail.setBody(composeRequest.getBody());
        mail.setDateTime(composeRequest.getDateTime());
    }
}
