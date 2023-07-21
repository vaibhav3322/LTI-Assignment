package com.vaibhav.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.blog.entities.Category;
import com.vaibhav.blog.entities.Post;
import com.vaibhav.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByCategory(Category category);
	List<Post> findByUser(User user);

}
