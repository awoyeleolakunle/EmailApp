package services;

import data.model.Mail;
import data.model.User;
import data.repositories.*;
import dtos.Request.ComposeRequest;
import dtos.Request.RegisterRequest;
import utils.MailMapper;

public class MailServiceImpl implements MailService {

    private static MailRepository mailRepository = new MailRepositoryImpl();
    private User user = new User();
    private static RegisterRequest  registerRequest = new RegisterRequest();
    private static UserRepository userRepository = new UserRepositoryImpl();
    private static Mail mail;
    private static UserService userService = new UserServiceImpl();
    private ComposeRequest composeRequest = new ComposeRequest();

    @Override
    public Mail sendMail(String emailAddress, ComposeRequest composeRequest) {
        if (userService.findUser(emailAddress).getEmailAddress().equals(emailAddress)) {
            mail = new Mail();
            MailMapper.map(composeRequest, mail);
            return mailRepository.saveMail(mail);
        }
            return null;

    }

    @Override
    public Mail sendMail(int id, ComposeRequest composeRequest) {
        if (userService.findUser(id).getId() == id) {
            mail = new Mail();
            MailMapper.map(composeRequest, mail);
            return mailRepository.saveMail(mail);
        }
        return null;
    }

    @Override
    public Mail findMail(int id) {
        return mailRepository.findById(id);
    }

    @Override
    public Mail findMail(String subject) {
        if (mailRepository.findMailBySubject(subject).getSubject().equals(subject)) {

            Mail savedMail = mailRepository.findMailBySubject(subject);
            System.out.println(savedMail.toString());
            return savedMail;
        }
        return null ;
    }

    @Override
    public void receiveMail() {

    }

    @Override
    public void deleteMail(int id) {

    }

    @Override
    public Mail saveEmail(ComposeRequest composeRequest) {
        Mail mail = new Mail();
        MailMapper.map(composeRequest,mail);
        return mailRepository.saveMail(mail);
    }
}
