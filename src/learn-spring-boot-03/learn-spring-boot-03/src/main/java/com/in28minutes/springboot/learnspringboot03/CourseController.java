package com.in28minutes.springboot.learnspringboot03;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	// /courses
	// Course: id, name, author
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses() {
		return Arrays.asList(
					new Course(1, "Learn AWS", "in28minutes"),
					new Course(1, "Learn Devops", "in28minutes")
				);
	}

}