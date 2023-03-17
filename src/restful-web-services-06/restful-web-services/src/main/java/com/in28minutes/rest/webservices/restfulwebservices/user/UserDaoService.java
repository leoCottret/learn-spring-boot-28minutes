package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User save(User todo) {
		return userRepository.save(todo);
	}
	
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}
}

