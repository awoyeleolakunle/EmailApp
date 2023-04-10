package data.repositories;

import data.model.Email;

public interface EmailRepository {

    Email saveEmailAccount(Email mailAccount);
    Email findEmailAccountByEmailAddress(String emailAddress);
    void deleteEmailAccountByEmailAddress(String emailAddress);
    void deleteAllEmailAccounts();
    int count();

    Email findById(int Id);

    void deleteById(int Id);
}
