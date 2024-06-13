package com.fotomilenio.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendBirthdayGreetings(String to, String name) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject("¡Feliz Cumpleaños!");
        mailMessage.setText("Hola " + name + ",\n\nFelicitaciones en tu día especial. ¡Que tengas un gran día!\n\nSaludos,\nTu Empresa");

        javaMailSender.send(mailMessage);
    }
}

