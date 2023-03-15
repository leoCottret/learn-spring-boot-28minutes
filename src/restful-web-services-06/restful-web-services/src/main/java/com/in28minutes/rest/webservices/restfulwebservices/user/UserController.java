package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return service.findAll();
	}	
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		return service.findById(id);
	}
	
	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		service.save(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@PutMapping("/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable int id) {
		if (user.getId() != id) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		} 
		service.save(user);
	}
}
