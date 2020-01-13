package net.timeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.timeline.entities.User;
import net.timeline.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	// signup
	@RequestMapping("/create")
	public String create(User user) {
		
		userRepository.save(user);
		
		return "user/signin";
		
	}
	//login
	@RequestMapping("/")
	public String login() {
		return "";
			
	}
		
	

}
