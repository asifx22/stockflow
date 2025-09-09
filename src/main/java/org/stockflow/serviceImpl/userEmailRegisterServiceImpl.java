package org.stockflow.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.stockflow.service.EmailService;
@Service
public class userEmailRegisterServiceImpl implements EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void SendMail(String to, String subject, String body) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(body);
        javaMailSender.send(mail);


    }
}
