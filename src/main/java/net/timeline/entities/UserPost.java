package net.timeline.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserPost {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	private String contents;
	private LocalDateTime createDate;
	
	private Integer likeCount = 0;
	
	
	public UserPost() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public UserPost(String title, String contents, LocalDateTime createDate) {
		super();
		this.title = title;
		this.contents = contents;
		this.createDate = LocalDateTime.now();
	
	}




	public String getFormatCreateDate() {
		if(createDate.equals("")) {
			return null;
		}
		
		return createDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mma z"));
	}
	
	public void likeAdd() {
		this.likeCount += 1;
		
		if(likeCount > 1) {
			this.likeCount = 0;
		}
		
	}
	
	

}
