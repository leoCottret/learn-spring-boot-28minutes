package com.in28minutes.springboot.firstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
	// eg: GET param
	@RequestMapping("login")
	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		logger.debug("Request param is {}", name);
		return "login";
	}
}
