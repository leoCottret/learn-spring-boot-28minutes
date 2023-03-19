package com.in28minutes.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return service.findAll();
	}	
	
	@GetMapping("/users/{id}")
	public EntityModel<User> getUser(@PathVariable int id) {
		Optional<User> user = service.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
		}	
		EntityModel<User> entityModel = EntityModel.of(user.get());
		
		// get a full link of the url above getUsers()
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
		// add the link with the label "all-users"
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		// append /userId to current url, and add a "location" header to the response
		// which triggers a redirection when coupled with the 201 status code
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		Optional<User> user = service.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
		}
		service.deleteById(id);
	}
	
	@PutMapping("/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable int id) {
		if (user.getId() != id) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		} 
		service.save(user);
	}
	
	@GetMapping("/users/{id}/posts")
	public List<Post> getUserPosts(@PathVariable int id) {
		Optional<User> user = service.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
		}
		
		return user.get().getPosts();
	}
}
