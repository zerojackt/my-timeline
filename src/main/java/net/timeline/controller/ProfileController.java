package net.timeline.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.implementation.bytecode.Throw;
import net.timeline.entities.User;
import net.timeline.repository.UserRepository;


@Controller
@RequestMapping("/users")
public class ProfileController {
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@RequestMapping("/profile/{id}")
	public String create(@PathVariable Long id,Model model,HttpSession session) {
		
		// security
		User sessionUser = (User) session.getAttribute("sessionUser");
		
		

		if(!sessionUser.getId().equals(id)) {
			
			 throw new IllegalStateException("남의 글을 보지 마시오");
		}
		
		

		model.addAttribute("user",userRepository.findById(id).get());
		
		return "user/profile";
	}
	
	
	@RequestMapping("/profileForm/{id}")
	public String update(@PathVariable Long id,Model model,HttpSession session) {
		
		// security
		User sessionUser = (User) session.getAttribute("sessionUser");
		
		

		if(!sessionUser.getId().equals(id)) {
			
			 throw new IllegalStateException("남의 글을 보지 마시오");
		}
		
		
		model.addAttribute("user",userRepository.findById(id).get());
		return "/user/profileForm";
	}
	
	@RequestMapping("/updateForm/{id}")
	public String updateForm(@PathVariable Long id,String name,String email,String contents,String location,Model model,HttpSession session) {
		
		// security
		User sessionUser = (User) session.getAttribute("sessionUser");
		
		

		if(!sessionUser.getId().equals(id)) {
			
			 throw new IllegalStateException("남의 글을 보지 마시오");
		}
		
		
		User user = userRepository.findById(id).get();
		user.updateForm(name,email,contents,location);
		userRepository.save(user);
		
		return String.format("redirect:/users/profile/%d", id);
		
		
		
	}

}
