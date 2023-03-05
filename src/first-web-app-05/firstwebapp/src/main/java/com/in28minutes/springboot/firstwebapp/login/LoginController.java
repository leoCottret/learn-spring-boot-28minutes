package com.in28minutes.springboot.firstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	// /src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
	@RequestMapping("login")
	public String login() {
		return "login";
	}
}
