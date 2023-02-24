package com.in28minutes.learnspringboot.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes1.learnspringboot1")
public class DependencyInjectionApplication {
	
	public static void main(String[] args) {
		
		try (var context = new AnnotationConfigApplicationContext(DependencyInjectionApplication.class)) {
			context.getBean(GameRunner.class).run();	
		}
		
	}

}
