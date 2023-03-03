package data.repositories;

import data.model.Mail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailRepositoryImplTest {
    private MailRepository mailRepository;
    private Mail mail;

    @BeforeEach
    void setUp() {
        mailRepository = new MailRepositoryImpl();
        mail = new Mail();
    }
    @Test
    public void saveMail_AccountIsOneTest(){
        mail = mailRepository.saveMail(mail);
        assertEquals(1,mailRepository.count());
    }
    @Test
    public void findMailByMailSubjectTest(){
        mail.setSubject("The Lord is my Shepherd");
        mail = mailRepository.saveMail(mail);
        System.out.println(mailRepository.findMailBySubject("The Lord is my Shepherd"));
        System.out.println(mailRepository.findById(1));
        System.out.println(mail);
        assertEquals(mail, mailRepository.findMailBySubject("The Lord is my Shepherd"));
    }

    @Test
    public void findMailByIdTest(){
        mail = mailRepository.saveMail(mail);
        mailRepository.findById(1);
        assertEquals(1, mailRepository.findById(1).getId());
    }
    @Test
    public void deleteMailByIdTest(){
        mail = mailRepository.saveMail(mail);
        mailRepository.deleteMail(mail.getId());
        assertEquals(0, mailRepository.count());
    }
    @Test
    public void deleteMailByMailSubjectTest(){
        mail = mailRepository.saveMail(mail);
        mail.setSubject("The Lord Is My Shepherd");
        mailRepository.deleteMailBySubject(mail.getSubject());
        assertEquals(0, mailRepository.count());

    }
    @Test
    public void mailWithSameId_CountIsOne(){
     mail = mailRepository.saveMail(mail);
     Mail newMail = new Mail();
     newMail = mailRepository.saveMail(mail);
     Mail foundMail = mailRepository.findById(1);
     assertEquals(foundMail, mail);
    }
}