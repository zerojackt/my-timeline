package net.timeline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.timeline.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	

}
