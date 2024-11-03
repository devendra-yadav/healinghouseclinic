package com.dev.hhclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.hhclinic.service.EmailService;

@RestController
public class TestController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("/testmail")
	public String sendMail() {
		
		emailService.sendEmail("devendra.yadav@gmail.com", "COming frm spring mail", "Kaisan ba");
		
		return "Mail sent";
	}
}
