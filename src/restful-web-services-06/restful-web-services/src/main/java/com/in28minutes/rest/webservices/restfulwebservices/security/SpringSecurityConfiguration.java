package com.in28minutes.rest.webservices.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()); // all requests need to be authenticated
			http.httpBasic(withDefaults()); // if a request is not authenticated, ask for basic authentication (pop up)
			http.csrf().disable(); // disable CSRF protection to allow for POST/PUT requests
			
			return http.build();
		}
	
}
