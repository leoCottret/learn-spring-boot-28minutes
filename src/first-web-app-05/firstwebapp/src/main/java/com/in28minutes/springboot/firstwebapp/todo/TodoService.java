package com.in28minutes.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

public class TodoService {

	private static List<Todo> todos;

	// to initialise a static variable, you need a static block
	static {
		todos.add(new Todo(1, "Léo", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(2, "Léo", "Learn DevOps", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(3, "Léo", "Learn Full Stack Development", LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsername(String username) {
		return todos;
	}
}
