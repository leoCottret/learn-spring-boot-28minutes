package com.in28minutes1.learnspringboot1;

import com.in28minutes1.learnspringboot1.game.GameRunner;
import com.in28minutes1.learnspringboot1.game.MarioGame;
import com.in28minutes1.learnspringboot1.game.SuperContraGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		// var marioGame = new MarioGame();	
		var superContraGame = new SuperContraGame();		
		var gameRunner = new GameRunner(superContraGame);
		gameRunner.run();
	}

}
