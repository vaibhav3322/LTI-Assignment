package com.vaibhav.blog.controllers;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.blog.payloads.CategoryDto;
import com.vaibhav.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// create category
	@PostMapping("/createCategory")
	public ResponseEntity<CategoryDto> createCategoies(@Valid @RequestBody CategoryDto categoryDto) {

		CategoryDto createdCategory = this.categoryService.createCategory(categoryDto);

		return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);

	}

	// update category
	@PutMapping("/updatedCatgory/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable Integer categoryId) {
		CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);

	}

	// delete category
	@DeleteMapping("/deleteCategory/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") Integer categoryId) {

		this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity<>(("category deleted Successfully"), HttpStatus.OK);

	}

	// get all categories
	@GetMapping("/getCategories")
	public ResponseEntity<List<CategoryDto>> getCategories() {
		 List<CategoryDto> categories = this.categoryService.getCategories();
		return ResponseEntity.ok(categories);

	}

	// get category by id
	@GetMapping("/getCategoryById/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId) {
		return ResponseEntity.ok(this.categoryService.getCategoryById(categoryId));

	}

}
