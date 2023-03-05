package com.in28minutes.springboot.firstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate (String username, String password) {
		boolean isValidUsername = username.equals("Léo");
		boolean isValidPassword = password.equals("test");
		return isValidUsername && isValidPassword;
	}
	
}
