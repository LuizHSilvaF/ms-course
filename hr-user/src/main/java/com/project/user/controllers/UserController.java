package com.project.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.user.entities.User;
import com.project.user.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = repo.findById(id).get();
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findById(@RequestParam String email){
		User obj = repo.findByEmail(email);
		return ResponseEntity.ok(obj);
	}
}
