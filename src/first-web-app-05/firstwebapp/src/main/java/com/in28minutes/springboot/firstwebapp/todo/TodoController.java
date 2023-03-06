package com.in28minutes.springboot.firstwebapp.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value="list-todos", method = RequestMethod.GET)
	public String listAllTodos(ModelMap model) {
		String name = "Léo";
		List<Todo> todos = todoService.findByUsername(name);
		model.addAttribute("name", name);
		model.addAttribute("todos", todos);
		return "listTodos";
	}
}
