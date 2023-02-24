package com.in28minutes1.learnspringboot1.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole {
	
	public void up() {
		System.out.println("Jump");
	}
	
	public void down() {
		System.out.println("Go into hole");
	}
	
	public void left() {
		System.out.println("Go backward");
	}
	
	public void right() {
		System.out.println("Go forward");
	}
	
}
