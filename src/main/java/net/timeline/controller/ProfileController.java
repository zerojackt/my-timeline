package net.timeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.timeline.entities.User;
import net.timeline.repository.UserRepository;


@Controller
@RequestMapping("/users")
public class ProfileController {
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@RequestMapping("/profile/{id}")
	public String create(@PathVariable Long id,Model model) {
		model.addAttribute("user",userRepository.findById(id).get());
		
		return "user/profile";
	}
	
	
	@RequestMapping("/profileForm/{id}")
	public String update(@PathVariable Long id,Model model) {
		model.addAttribute("user",userRepository.findById(id).get());
		return "/user/profileForm";
	}
	
	@RequestMapping("/updateForm/{id}")
	public String updateForm(@PathVariable Long id,String name,String email,String contents,String location,Model model) {
		
		User user = userRepository.findById(id).get();
		user.updateForm(name,email,contents,location);
		userRepository.save(user);
		
		return String.format("redirect:/users/profile/%d", id);
		
		
		
	}

}
