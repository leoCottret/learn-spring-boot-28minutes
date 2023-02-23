package com.in28minutes1.learnspringboot1.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {

		// 1: Launch a Spring Context
		// Try with resources, to be sure that the resource will be closed after the execution of the block
		// Similar to -> try { var resource = new Something(); } catch (...) {...} finally (...) { resource.close(); }
		try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			
			// 2: Configure the things that we want Spring to manage - 
			// @Configuration - Our HelloWorldConfiguration class
			// @Bean - Our Bean "name", in the HelloWorldConfiguration class
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("person2MethodCall"));
			System.out.println(context.getBean("person3Parameters"));
			System.out.println(context.getBean("address_custom"));
			System.out.println(context.getBean(Person.class));
			System.out.println(context.getBean(Address.class));
			
			System.out.println("\nDisplay all Spring Boot Beans ->\n");
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
		}
		
		Person p = null;
		if ( p != null ) p = new Person("a", 2, new Address("Baker Street", "London"));
	}

}
