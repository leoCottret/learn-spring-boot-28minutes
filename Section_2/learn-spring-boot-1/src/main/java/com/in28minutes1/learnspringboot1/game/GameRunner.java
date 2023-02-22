package com.in28minutes1.learnspringboot1.game;

public class GameRunner {
	private GamingConsole game;
	
	public GameRunner(GamingConsole game) {
		this.game = game;
	}

	public void run() {
		System.out.println("Running game: " + game);
		game.up();
		game.down();
		game.right();
		game.left();
		
	}
	
}
