package com.vaibhav.blog.services;

import java.util.List;

import com.vaibhav.blog.payloads.CategoryDto;
import com.vaibhav.blog.payloads.UserDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);

	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	CategoryDto getCategoryById(Integer categoryId);

	List<CategoryDto> getCategories();

	void deleteCategory(Integer categoryId);

}
