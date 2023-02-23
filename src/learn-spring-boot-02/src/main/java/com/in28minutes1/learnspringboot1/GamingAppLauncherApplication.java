package com.in28minutes1.learnspringboot1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes1.learnspringboot1.game.GameRunner;
import com.in28minutes1.learnspringboot1.game.GamingConsole;
import com.in28minutes1.learnspringboot1.game.MarioGame;
import com.in28minutes1.learnspringboot1.game.PacmanGame;
import com.in28minutes1.learnspringboot1.game.SuperContraGame;

@Configuration
@ComponentScan("com.in28minutes1.learnspringboot1.game")
public class GamingAppLauncherApplication {
	
	public static void main(String[] args) {
		
		try (var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
			context.getBean(GameRunner.class).run();	
		}
		
	}

}
