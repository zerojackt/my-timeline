package net.timeline.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.timeline.entities.UserPost;
import net.timeline.repository.UserPostRepository;

@Controller
@RequestMapping("/post")
public class UserPostController {
	
	@Autowired
	private UserPostRepository userPostRepository;
	
	@RequestMapping("")
	public String post() {
		
		
		
		return"user/post";
		
	}
	
	@RequestMapping("/create")
	public String create(String title,String contents,LocalDateTime createDate) {
		
		UserPost userPost = new UserPost(title,contents,createDate);
		userPostRepository.save(userPost);
		
		return "redirect:/";
		
	}

}
