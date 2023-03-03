package data.repositories;

import data.model.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailRepositoryImplTest {

    private EmailRepository emailRepository;
    private Email email;

    @BeforeEach
    void setUp() {
        emailRepository = new EmailRepositoryImpl();
        email = new Email();
    }

    @Test
    public void saveEmail_CountIsOneTest() {
        emailRepository.saveEmailAccount(email);
        assertEquals(1, emailRepository.count());
    }

    @Test

    public void findEmailEmailAddressTest() {
        emailRepository.saveEmailAccount(email);
        email.setEmailAddress("Chibuzo@gmail.com");
        emailRepository.findEmailAccountByEmailAddress("Chibuzo@gmail.com");
        assertEquals("Chibuzo@gmail.com", emailRepository.findEmailAccountByEmailAddress("Chibuzo@gmail.com").getEmailAddress());
    }

    @Test
    public void findEmailAccountByIdTest() {
        Email newSaved = emailRepository.saveEmailAccount(email);
        Email foundEmail = emailRepository.findById(1);
        assertEquals(foundEmail, newSaved);
    }

    @Test

    public void emailAccountCanBeDeletedByEmailAddressTest() {
        email = emailRepository.saveEmailAccount(email);
        email.setEmailAddress("Chibuzo@gmail.com");
        emailRepository.deleteEmailAccountByEmailAddress(email.getEmailAddress());
        assertEquals(0, emailRepository.count());
    }

    @Test
    public void emailAccountCanBeDeletedByIdTest() {
        email = emailRepository.saveEmailAccount(email);
        emailRepository.deleteById(1);
        assertEquals(0, emailRepository.count());
    }

    @Test
    public void allEmailAccountsCanBeDeletedTest() {
        email = emailRepository.saveEmailAccount(email);
        emailRepository.deleteAllEmailAccounts();
        assertEquals(0, emailRepository.count());

    }
}