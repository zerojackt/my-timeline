package net.timeline.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.timeline.entities.User;
import net.timeline.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	// signup
	@RequestMapping("/signupForm")
	public String signupForm() {
		
		return "user/signup";
	}
	
	@RequestMapping("/create")
	public String create(User user) {
		
		userRepository.save(user);
		
		
		return "redirect:/";
		
	}
	
	//login
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "/user/login";
			
	}
	
	@RequestMapping("/login")
	public String login(String email,HttpSession session) {
		User user = userRepository.findByEmail(email);
		
		if(!user.getEmail().equals(email)) {
			
			return "redirect:/";
		}
		
		session.setAttribute("sessionUser", user);
		
		return "redirect:/";
			
	}
	
	//timeline
		@RequestMapping("/{id}/timeline")
		public String timeline(@PathVariable Long id) {
			return "user/timeline";
				
		}
		
		
		
	
	
	
	
		
	

}
