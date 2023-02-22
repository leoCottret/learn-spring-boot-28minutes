package com.in28minutes1.learnspringboot1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// record (released in JDK 16)
// eliminate verbosity in creating Java Beans
// public accessor methods, constructor, equals, hashcode and toString are automatically created
record Person(String name, int age) {};
record Address(String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		return "Léo";
	}
	
	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		return new Person("Léa", 16);
	}
	
	@Bean
	public Address address() {
		return new Address("Baker Street", "London");
	}
}
