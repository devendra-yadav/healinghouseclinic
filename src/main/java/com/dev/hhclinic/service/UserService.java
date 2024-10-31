package com.dev.hhclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.hhclinic.entity.User;
import com.dev.hhclinic.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).get();
	}

}
