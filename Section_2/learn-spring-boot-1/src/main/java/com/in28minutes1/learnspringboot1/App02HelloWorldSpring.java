package com.in28minutes1.learnspringboot1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {


		// 1: Launch a Spring Context
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		
		// 2: Configure the things that we want Spring to manage - 
		// @Configuration - Our HelloWorldConfiguration class
		// @Bean - Our Bean "name", in the HelloWorldConfiguration class
		System.out.println(context.getBean("name"));
	}

}
