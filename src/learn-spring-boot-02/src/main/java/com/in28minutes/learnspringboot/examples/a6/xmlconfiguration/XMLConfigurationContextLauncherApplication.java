package com.in28minutes.learnspringboot.examples.a6.xmlconfiguration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.in28minutes.learnspringframework.game.GameRunner;

public class XMLConfigurationContextLauncherApplication {
	
	public static void main(String[] args) {
		
		try (var context = new ClassPathXmlApplicationContext("file:src/main/resources/contextConfiguration.xml")) {
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			System.out.println(context.getBean("name"));
			
			context.getBean(GameRunner.class).run();			
			
		}
		
	}

}
