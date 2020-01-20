package net.timeline.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import net.timeline.entities.User;
import net.timeline.repository.UserPostRepository;
import net.timeline.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserPostRepository userPostRepository;
	
	
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
	//logout
	@RequestMapping("/logoutForm")
	public String logout(HttpSession session) {
	
		session.removeAttribute("sessionUser");
		return "redirect:/";
		
	}
	
	//timeline
		@RequestMapping("/timeline")
		public String timeline(Model model) {
			model.addAttribute("userPost",userPostRepository.findAll());
			
			
			return "user/timeline";
				
		}
		
		
		
	
	
	
	
		
	

}
