package data.repositories;

import data.model.Mail;

import java.util.ArrayList;
import java.util.List;

public class MailRepositoryImpl implements MailRepository{

    private int count;
    private List<Mail>mails = new ArrayList<>();
    @Override
    public Mail saveMail(Mail mail) {
        boolean hasNotBeencreated = mail.getId()==0;
        if (hasNotBeencreated){
        mail.setId(generateId());
        mails.add(mail);
        count++;}
        return mail;
    }

    private int generateId() {
        return count+1;
    }

    @Override
    public Mail findMailBySubject(String mailSubject) {
        for (Mail mail: mails) {
            if(mail.getSubject().equals(mailSubject)) {
                System.out.println(mail);
                return mail;
            }
            break;
        }return null;
    }

    @Override
    public void deleteMailBySubject(String mailSubject) {
        for (Mail mail: mails) {
            if(mail.getSubject().equals(mailSubject)){
                mails.remove(mail);
                count--;
            }
            break;
        }
    }

    @Override
    public void deleteMail(int id) {
        for (Mail mail:mails) {
            if(mail.getId()==id){
                mails.remove(mail);
                count--;
            }
            break;
        }
    }

    @Override
    public void deleteAllMail() {

    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public Mail findById(int Id) {
        for (Mail mail: mails){
            if(mail.getId()==Id){
                return mail;
            }
        } return null;
    }
}
