package com.in28minutes.springboot.firstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	// real app -> LDAP or Database
	// here, we'll store users/pass in memory

	// InMemoryUserDetailsManager
	// InMemoryUserDetailsManager(UserDetails... users)

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {

		UserDetails userDetails = createNewUser("Léo", "Test");
		UserDetails userDetails2 = createNewUser("Léa", "Test2");

		return new InMemoryUserDetailsManager(userDetails, userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(username).password(password)
				.roles("USER", "ADMIN").build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()); // all requests need to be authenticated
		http.formLogin(withDefaults()); // show the login form at '/login' if not logged in (otherwise an error is thrown in that case)
		http.csrf().disable(); // disable CSRF protection
		http.headers().frameOptions().disable(); // disable spring pages not allowed to be displayed in frames
		return http.build();
	}

}
