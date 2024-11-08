package com.dev.hhclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.hhclinic.service.EmailService;

@RestController
public class TestController {
	
	private EmailService emailService;
	
	@Autowired
	public TestController(EmailService emailService) {
		this.emailService=emailService;
	}
	
	@GetMapping("/testmail")
	public String sendMail() {
		
		emailService.sendEmail("devendra.yadav@gmail.com", "COming frm spring mail", "Kaisan ba");
		
		return "Mail sent";
	}
}
