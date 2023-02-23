package com.in28minutes1.learnspringboot1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes1.learnspringboot1.game.GameRunner;
import com.in28minutes1.learnspringboot1.game.GamingConsole;
import com.in28minutes1.learnspringboot1.game.PacmanGame;


@Configuration
public class GamingSpringBeansConfiguration {

	@Bean
	public GamingConsole game() {
		return new PacmanGame();
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		return new GameRunner(game);
	}
}
