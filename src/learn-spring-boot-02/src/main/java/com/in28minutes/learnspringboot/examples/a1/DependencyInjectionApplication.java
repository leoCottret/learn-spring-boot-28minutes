package com.in28minutes.learnspringboot.examples.a1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;

@Configuration
@ComponentScan
public class DependencyInjectionApplication {
	
	public static void main(String[] args) {
		
		try (var context = new AnnotationConfigApplicationContext(DependencyInjectionApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
		}
		
	}

}
