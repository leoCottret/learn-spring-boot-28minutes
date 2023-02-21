package com.in28minutes1.learnspringboot1.game;

public class GameRunner {
	private SuperContraGame game;
	
	public GameRunner(SuperContraGame game) {
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
