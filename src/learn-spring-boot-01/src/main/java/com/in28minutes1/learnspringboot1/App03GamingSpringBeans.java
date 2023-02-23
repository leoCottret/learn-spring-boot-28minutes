package com.in28minutes1.learnspringboot1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes1.learnspringboot1.game.GameRunner;
import com.in28minutes1.learnspringboot1.game.MarioGame;
import com.in28minutes1.learnspringboot1.game.PacmanGame;
import com.in28minutes1.learnspringboot1.game.SuperContraGame;
import com.in28minutes1.learnspringboot1.helloworld.HelloWorldConfiguration;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
		
		try (var context = new AnnotationConfigApplicationContext(GamingSpringBeansConfiguration.class)) {
			context.getBean(GameRunner.class).run();	
		}
		
	}

}
