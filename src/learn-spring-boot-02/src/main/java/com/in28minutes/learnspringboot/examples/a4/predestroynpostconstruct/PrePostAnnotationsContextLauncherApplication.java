package com.in28minutes.learnspringboot.examples.a4.predestroynpostconstruct;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.in28minutes.learnspringboot.game.GameRunner;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

// Should be in their own files, ofc


@Component
class SomeClass {
	
	private SomeDepedency someDepedency;

	public SomeClass(SomeDepedency someDepedency) {
		super();
		this.someDepedency = someDepedency;
		System.out.println("All dependencies are ready");
	}
	
	@PostConstruct
	public void initialize() {
		someDepedency.getReady();
	}
	
	@PreDestroy
	public void someCleanUp() {
		System.out.println("Clean up!");
	}
}

@Component
class SomeDepedency {
	
	public void getReady() {
		System.out.println("Some logic using dependencies");
	}
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
	
	public static void main(String[] args) {
		
		try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
		}
		
	}

}
