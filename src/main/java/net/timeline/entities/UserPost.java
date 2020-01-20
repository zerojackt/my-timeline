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
	
		
		return createDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm"));
	}
	
	
	
	

}
