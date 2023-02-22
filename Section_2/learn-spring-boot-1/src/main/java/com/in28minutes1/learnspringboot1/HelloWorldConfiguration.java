package com.in28minutes1.learnspringboot1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// record (released in JDK 16)
// eliminate verbosity in creating Java Beans
// public accessor methods, constructor, equals, hashcode and toString are automatically created
record Person(String name, int age, Address address) {};
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
		return new Person("Léa", 16, address_custom());
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address_custom_2());//name, age
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address_custom_3) {
		return new Person(name, age, address_custom_3);//name, age, address_custom
	}
	
	@Bean(name = "address_custom")
	public Address address_custom() {
		return new Address("Baker Street", "London");
	}
	
	@Bean(name = "address_custom_2")
	public Address address_custom_2() {
		return new Address("Baker Street2", "London");
	}
	
	@Bean(name = "address_custom_3")
	public Address address_custom_3() {
		return new Address("Baker Street3", "London");
	}
}
