package com.vaibhav.blog.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.blog.entities.Category;
import com.vaibhav.blog.entities.User;
import com.vaibhav.blog.exceptions.ResourceNotFoundException;
import com.vaibhav.blog.payloads.CategoryDto;
import com.vaibhav.blog.payloads.UserDto;
import com.vaibhav.blog.repositories.CategoryRepo;
import com.vaibhav.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category categoryCreated = this.categoryRepo.save(category);
		return this.modelMapper.map(categoryCreated, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category categoryupdated = this.categoryRepo.save(category);
		return this.modelMapper.map(categoryupdated, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> list = this.categoryRepo.findAll();
		List<CategoryDto> catDtos = list.stream().map(cat -> this.categoryToDto(cat))
				.collect(Collectors.toList());
		
		//List<UserDto> collect = findAllUsers.stream().map(u -> this.userToDto(u)).collect(Collectors.toList());
		return catDtos;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
		this.categoryRepo.delete(cat);
	}
    
	public Category dtoToCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return category;
	}
	
	public CategoryDto categoryToDto(Category category) {
		CategoryDto categoryDto =this.modelMapper.map(category,CategoryDto.class);
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		return categoryDto;

	}
}
