package com.in28minutes1.learnspringboot1;

import com.in28minutes1.learnspringboot1.game.GameRunner;
import com.in28minutes1.learnspringboot1.game.MarioGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		var marioGame = new MarioGame();		
		var gameRunner = new GameRunner(marioGame);
		gameRunner.run();
	}

}
