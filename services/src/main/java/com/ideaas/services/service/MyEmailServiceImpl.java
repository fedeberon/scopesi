package com.ideaas.services.service;

import com.ideaas.services.bean.Email;
import com.ideaas.services.service.interfaces.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;

@Service
public class MyEmailServiceImpl implements EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public MyEmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void send(Email email) throws MessagingException {

    }
}
