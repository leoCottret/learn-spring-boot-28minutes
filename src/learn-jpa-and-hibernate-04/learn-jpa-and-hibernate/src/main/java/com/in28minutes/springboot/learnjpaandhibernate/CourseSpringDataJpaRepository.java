package com.in28minutes.springboot.learnjpaandhibernate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

	// no need to define the body if you follow the naming convention
	List<Course> findByAuthor(String author);

	List<Course> findByName(String string);
}
