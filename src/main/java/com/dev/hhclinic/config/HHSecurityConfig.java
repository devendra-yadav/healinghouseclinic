package com.dev.hhclinic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.dev.hhclinic.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class HHSecurityConfig {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Bean
	public SecurityFilterChain securityChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf->csrf.disable())
			.formLogin(form->form.loginPage("/login").permitAll())
			.authorizeHttpRequests(req->req.requestMatchers("/cssandjs/**","/images/**").permitAll())
			.authorizeHttpRequests(req->req.anyRequest().authenticated());
		
		return http.build();
	}
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(passwordEncoder());
		
		authProvider.setUserDetailsService(userDetailsService);
		
		return authProvider;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
}
