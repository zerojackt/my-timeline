package net.timeline.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
public class UserPost {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	@Lob
	private String contents;
	private LocalDateTime createDate;
	
	private int likeCount;
	
	
	
	
	public UserPost() {
		// TODO Auto-generated constructor stub
	}
	


	public UserPost(String title, String contents, LocalDateTime createDate,int likeCount) {
		super();
		this.title = title;
		this.contents = contents;
		this.createDate = LocalDateTime.now();
		this.likeCount = likeCount;
	
	}




	public String getFormatCreateDate() {
	
		
		return createDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm"));
	}





	public void addLikeCount() {
		this.likeCount += 1;
		
		
		if(likeCount >1) {
			this.likeCount -= 2;
		}
		
	}




	
	
	

}
