package com.idihia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.idihia.entity.User;
import com.idihia.repository.UserRepository;

@RestController
public class UserController {
	
	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		
		super();
		this.userRepository = userRepository;
	}
	
	@GetMapping("/all")
	public List<User> getAllUsers(){
		
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		
		return userRepository.findById(id).get();
	}
	
	
	@PostMapping
	public User crateUser(@RequestBody User user) {
		
		return userRepository.save(user);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user ,@PathVariable Long id){
		
		User old = userRepository.findById(id).get();
		old.setFirstName(user.getFirstName());
		old.setLastName(user.getLastName());
		old.setEmail(user.getEmail());
		return userRepository.save(old);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteById(@PathVariable Long id){
		User user = userRepository.findById(id).get();
		userRepository.delete(user);
		return ResponseEntity.ok().build();

	}

}
