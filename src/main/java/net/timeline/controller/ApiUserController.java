package net.timeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.timeline.entities.User;
import net.timeline.repository.UserRepository;

@RestController
@RequestMapping("/users/api")
public class ApiUserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/{id}")
	public User apitest(@PathVariable Long id) {
		return userRepository.findById(id).get();
	}

}
