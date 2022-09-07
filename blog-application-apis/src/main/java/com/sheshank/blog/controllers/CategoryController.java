package com.sheshank.blog.controllers;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.sheshank.blog.payloads.ApiResponse;
import com.sheshank.blog.payloads.CategoryDto;
import com.sheshank.blog.services.CategoryServices;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryServices categoryServices;

	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {

		CategoryDto createCategoryDto = this.categoryServices.createCategory(categoryDto);

		return new ResponseEntity<CategoryDto>(createCategoryDto, HttpStatus.CREATED);

	}

	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable Integer categoryId) {
		CategoryDto updateCategory = categoryServices.updateCategory(categoryDto, categoryId);
		return ResponseEntity.ok(updateCategory);
	}

	//single category
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId) {
		return ResponseEntity.ok(categoryServices.getCategoryById(categoryId));
	}
	
	//get list of categories
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategories(){
		return ResponseEntity.ok(categoryServices.getCategoriesList());
	}
	
	@DeleteMapping("/{categoryId}")
	
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
		categoryServices.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully",true),HttpStatus.OK);
	}

}
