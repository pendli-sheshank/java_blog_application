package com.sheshank.blog.services;

import java.util.List;

import com.sheshank.blog.payloads.CategoryDto;

public interface CategoryServices {

	CategoryDto createCategory(CategoryDto category);

	CategoryDto updateCategory(CategoryDto category, Integer categoryId);

	CategoryDto getCategoryById(Integer categoryId);

	List<CategoryDto> getCategoriesList();

	void deleteCategory(Integer categoryId);
}
