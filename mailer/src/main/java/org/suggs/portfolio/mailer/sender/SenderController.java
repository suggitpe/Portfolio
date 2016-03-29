package org.suggs.portfolio.mailer.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenderController {

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping("/email")
    @ResponseStatus(HttpStatus.CREATED)
    public SimpleMailMessage send(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("me@suggs.org.uk");
        message.setReplyTo("someone@localhost");
        message.setFrom("someone@localhost");
        message.setSubject("Test subject");
        message.setText("Test email content");
        mailSender.send(message);
        return message;
    }
}
