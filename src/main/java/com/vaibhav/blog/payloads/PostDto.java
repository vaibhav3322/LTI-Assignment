package com.vaibhav.blog.payloads;

import java.util.Date;

import com.vaibhav.blog.entities.Category;
import com.vaibhav.blog.entities.User;

public class PostDto {

	private String title;

	private String content;

	private String imageName;

	private Date postDate;

	private CategoryDto category;

	private UserDto user;

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public PostDto(String title, String content, String imageName, Date postDate, CategoryDto category, UserDto user) {
		super();
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.postDate = postDate;
		this.category = category;
		this.user = user;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "PostDto [title=" + title + ", content=" + content + ", imageName=" + imageName + ", postDate="
				+ postDate + ", category=" + category + ", user=" + user + "]";
	}

	

	

	

}
