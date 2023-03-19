package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;

// careful, JpaRepository automatically creates CRUD routes 
public interface UserRepository extends JpaRepository<User, Integer>{

}