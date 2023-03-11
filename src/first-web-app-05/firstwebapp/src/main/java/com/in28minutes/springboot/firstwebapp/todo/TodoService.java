package com.in28minutes.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();

	private static int todosCount = 0;
	
	// to initialise a static variable, you need a static block
	static {
		todos.add(new Todo(++todosCount, "Léo", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Léo", "Learn DevOps", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Léo", "Learn Full Stack Development", LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsername(String username) {
		return todos;
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		todos.add(new Todo(++todosCount, username, description, targetDate, done));
	}
	
	public void deleteById(int id) {
		// lambda function
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;		
		todos.removeIf(predicate);
	}
}
