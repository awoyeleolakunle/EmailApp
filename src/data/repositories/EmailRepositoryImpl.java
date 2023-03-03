package data.repositories;

import data.model.Email;

import java.util.ArrayList;
import java.util.List;

public class EmailRepositoryImpl implements EmailRepository{

    private int count;
    private List<Email>emails = new ArrayList<>();

    @Override
    public Email saveEmailAccount(Email mailAccount) {
        boolean hasNotBeenCreated = (mailAccount.getEmailAddress()==null) && mailAccount.getId()==0;
        if(hasNotBeenCreated){
            mailAccount.setId(generateId());
        emails.add(mailAccount);
        count++;}
        return mailAccount;
    }

    @Override
    public Email findEmailAccountByEmailAddress(String emailAddress) {
        for(Email email: emails){
         if(email.getEmailAddress().equals(emailAddress)){
             return email;
         }
        }return null;
    }

    @Override
    public void deleteEmailAccountByEmailAddress(String emailAddress) {
        for (Email email: emails) {
            if (email.getEmailAddress().equals(emailAddress)){
                emails.remove(email);
                count--;
            }
            break;
        }

    }

    @Override
    public void deleteAllEmailAccounts() {

        emails.removeAll(emails);
        count = emails.size();
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public Email findById(int Id) {
        for (Email email:emails) {
            if(email.getId()==Id) {
                return email;
            }
            break;
        }
           return null;
    }

    @Override
    public void deleteById(int Id) {
        for (Email email: emails) {
            if(email.getId()==Id){
                emails.remove(email);
                count--;
            }
            break;
        }
    }

    public int generateId(){
        return count+1;
    }
}
