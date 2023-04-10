package data.repositories;

import data.model.Mail;

import java.util.List;

public interface MailRepository {
    Mail saveMail(Mail mail);
    Mail findMailBySubject(String mailSubject);
    void deleteMailBySubject(String mailSubject);
    void deleteMail(int id);
    void deleteAllMail();
    int count();

    Mail findById(int Id);

    List<Mail> findAllMail();

    int totalNumberOfMail();
}
