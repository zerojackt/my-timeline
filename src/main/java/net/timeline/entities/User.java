package net.timeline.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class User {
	
	


	@Id
	@GeneratedValue
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String name;
	@JsonProperty
	private String email;
	
	@JsonIgnore
	private String password;
	
	private String contents ;
	private String location ;
	
	
	
	




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	


	public User() {
			// TODO Auto-generated constructor stub
	}

	public void updateForm(String name, String email, String contents, String location) {
		
		this.name = name;
		this.email = email;
		this.contents = contents;
		this.location = location;
	}



	
	
	
	
	
	

}
