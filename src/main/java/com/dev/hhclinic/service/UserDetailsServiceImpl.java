package com.dev.hhclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dev.hhclinic.entity.User;
import com.dev.hhclinic.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("User tried to login "+username);
		
		User user = userRepository.findByUsername(username).get();
		
		if(user == null) {
			throw new UsernameNotFoundException("User "+username+" not found !!");
		}
		
		UserDetails userDetails = org.springframework.security.core.userdetails.User.builder().username(username).password(user.getPassword()).roles(user.getRole()).build();
		
		return userDetails;
	}

	
}
