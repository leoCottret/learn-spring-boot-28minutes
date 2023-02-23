package com.in28minutes1.learnspringboot1.game;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	private GamingConsole game;
	
	// Will automatically pick Pacman if it's the only class with a @Component annotation
	public GameRunner(GamingConsole game) {
		this.game = game;
	}

	public void run() {
		System.out.println("Running game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
		
	}
	
}
