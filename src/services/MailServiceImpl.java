package services;

import data.model.Mail;
import data.model.User;
import data.repositories.MailRepository;
import data.repositories.MailRepositoryImpl;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.Request.ComposeRequest;
import dtos.Request.RegisterRequest;
import dtos.Response.FindMailResponse;
import utils.MailMapper;

import java.util.ArrayList;
import java.util.List;

public class MailServiceImpl implements MailService {

    private static MailRepository mailRepository = new MailRepositoryImpl();
    private User user = new User();
    private static RegisterRequest registerRequest = new RegisterRequest();
    private static UserRepository userRepository = new UserRepositoryImpl();
    private static Mail mail;
    private static UserService userService = new UserServiceImpl();
    private ComposeRequest composeRequest = new ComposeRequest();



    @Override
    public FindMailResponse sendMail(String senderEmailAddress, String emailAddress, ComposeRequest composeRequest) {
        if (userService.findUser(emailAddress).getEmailAddress().equals(emailAddress)) {
            FindMailResponse response = new FindMailResponse();
            mail = new Mail();
            MailMapper.map(composeRequest, mail);
            mailRepository.saveMail(mail);
            userService.userInboxMail(emailAddress, mail);
            userService.userOutBoxMail(senderEmailAddress, mail);
            response.setId(mail.getId());
            response.setSubject(mail.getSubject());
            response.setBody(mail.getBody());
            response.setDateTime(mail.getDateTime());

            return response;

        }
        return null;

    }

    @Override
    public Mail findMail(int id) {
        return mailRepository.findById(id);
    }

    @Override
    public FindMailResponse findMail(String subject) {
        System.out.println(mailRepository.findMailBySubject(subject) + "I'm the found mail");
        if (mailRepository.findMailBySubject(subject).getSubject().equals(subject)) {
            mail = mailRepository.findMailBySubject(subject);
            FindMailResponse response = new FindMailResponse();
            response.setId(mail.getId());
            response.setSubject(mail.getSubject());
            response.setBody(mail.getBody());
            response.setDateTime(mail.getDateTime());
            System.out.println(response);
            return response;
        }
        return null ;
    }

    @Override
    public void receiveMail() {

    }

    @Override
    public String deleteMail(int id){
        if (!(mailRepository.findById(id).getId() ==id)) throw new IndexOutOfBoundsException("Mail not found");

        mailRepository.deleteMail(id);
    return "Email deleted successfully";
    }

    @Override
    public FindMailResponse saveEmail(ComposeRequest composeRequest) {
          mail = new Mail();
        MailMapper.map(composeRequest,mail);
        mailRepository.saveMail(mail);
        FindMailResponse response = new FindMailResponse();
        response.setSubject(mail.getSubject());
        response.setBody(mail.getBody());
        response.setId(mail.getId());
        response.setDateTime(mail.getDateTime());
        return response;
    }

    @Override
    public List<Mail> findAllMails() {
        return mailRepository.findAllMail();
    }



}
