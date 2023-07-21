package com.vaibhav.blog.services;

import java.util.List;

import com.vaibhav.blog.entities.Post;
import com.vaibhav.blog.payloads.PostDto;

public interface PostService {
	
	//create
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//upadte
	Post updatePost(PostDto postDto, Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all post
	List<Post> getAllPost();
	
	//get single post
	Post getPostById(Integer postId);
	
	//get posts by category
	List<PostDto> getPostsByCategory(Integer postId);
	
	//get posts by user
	List<PostDto> getPostsByUser(Integer postId);
	
	//search posts
	List<Post> searchPosts(String keyword);
	
	
	
	
	

}
