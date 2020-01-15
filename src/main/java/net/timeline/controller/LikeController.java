package net.timeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.timeline.entities.UserPost;
import net.timeline.repository.UserPostRepository;

@RestController
@RequestMapping("/posts/{id}/like")
public class LikeController {
	
	@Autowired
	private UserPostRepository userPostRepository;
	
	@RequestMapping("")
	public String add(@PathVariable Long id) {
		
		UserPost userPost = userPostRepository.findById(id).get();
		userPost.likeAdd();
		userPostRepository.save(userPost);
		
		return "redirect:/";
	}

}
