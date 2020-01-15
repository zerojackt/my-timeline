package net.timeline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.timeline.entities.UserPost;

public interface UserPostRepository extends JpaRepository<UserPost, Long> {

}
