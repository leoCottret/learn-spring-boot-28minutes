package com.in28minutes.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	public List<Todo> findAllByUsername(String username) {
		return todoRepository.findAllByUsername(username);
	}

	public void save(Todo todo) {
		todoRepository.save(todo);
	}
	
	public void deleteById(int id) {
		todoRepository.deleteById(id);
	}

	public Todo findById(int id) {
		return todoRepository.findById(id).get();
	}

	public void updateTodo(@Valid Todo todo) {
		todoRepository.save(todo);
	}
}
