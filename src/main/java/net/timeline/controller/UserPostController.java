package net.timeline.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.timeline.entities.UserPost;
import net.timeline.repository.UserPostRepository;


@Controller
@RequestMapping("/users/post")
public class UserPostController {
	
	public static String uploadDirectory = System.getProperty("user.uir")+"/uploads";
	
	@Autowired
	private UserPostRepository userPostRepository;
	
	@RequestMapping("")
	public String post() {
		
		
		
		
		return"user/post";
		
	}
	
	@RequestMapping(value = ( "/create"),method=RequestMethod.POST)
	public String create(String title,int likeCount,String contents,LocalDateTime createDate,Model model) {
		
		UserPost userPost = new UserPost(title,contents,createDate,likeCount);
		userPostRepository.save(userPost);
		
		return "redirect:/";
		
	}
	
	@RequestMapping("/delete/{id}") 
	public String delete(@PathVariable Long id) {
		UserPost userPost = userPostRepository.findById(id).get();
		userPostRepository.delete(userPost);
		
		return "redirect:/users/timeline";
	}
	
	@RequestMapping("/like/{id}")
	public String like(@PathVariable Long id) {
		UserPost userPost = userPostRepository.findById(id).get();
		userPost.addLikeCount();
		userPostRepository.save(userPost);
		
		return "redirect:/users/timeline";
		
	}
	
	
	

}
