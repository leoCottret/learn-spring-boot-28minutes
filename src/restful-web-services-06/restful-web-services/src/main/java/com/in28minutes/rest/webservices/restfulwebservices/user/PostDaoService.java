package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostDaoService {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post save(Post todo) {
		return postRepository.save(todo);
	}
	
	public void deleteById(int id) {
		postRepository.deleteById(id);
	}

	public Optional<Post> findById(int id) {
		return postRepository.findById(id);
	}
}

