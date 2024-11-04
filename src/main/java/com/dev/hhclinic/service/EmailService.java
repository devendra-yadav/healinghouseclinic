package com.dev.hhclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String to, String subject, String body) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(to);
	
		mail.setSubject(subject);
		
		mail.setText(body);
		
		mailSender.send(mail);
		
		log.info("Mail sent to "+to);
		
	}
	
}
