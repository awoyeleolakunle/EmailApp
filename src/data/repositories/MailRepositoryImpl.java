package data.repositories;

import data.model.Mail;

import java.util.ArrayList;
import java.util.List;

public class MailRepositoryImpl implements MailRepository{

    private int count;

    private  List<Mail>mails = new ArrayList<>();
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
        System.out.println(mails.size() + " na here be the koko");
        for (Mail mail : mails) {
            System.out.println(mails.size() + " na my size be this");
            if (mail.getSubject().equals(mailSubject))
                return mail;}
            System.out.println(" nothing dey here");
            return null;

    }
    @Override
    public void deleteMailBySubject(String mailSubject) {
        for ( Mail mail: mails) {
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
    public Mail findById(int id) {
        return mails.get(id-1);
    }

    @Override
    public List<Mail> findAllMail() {
        return mails;
    }

    @Override
    public int totalNumberOfMail() {
        return mails.size();
    }
}
