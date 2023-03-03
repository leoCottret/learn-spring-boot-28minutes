package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
//	@Autowired
//	private CourseJdbcRepository repository;
	
	@Autowired
	private CourseJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1, "Learn AWS now - JPA", "in28minutes"));
		repository.insert(new Course(2, "Learn Azure now", "in28minutes"));
		repository.insert(new Course(3, "Learn Machine Learning now", "in28minutes"));
		repository.insert(new Course(4, "Should be deleted", "in28minutes"));
		repository.deleteById(4);
		System.out.println(repository.findById(1));
	}
	
	
}
