package com.sheshank.blog.serviceImple;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheshank.blog.entities.Category;
import com.sheshank.blog.exceptions.ResourceNotFoundException;
import com.sheshank.blog.payloads.CategoryDto;
import com.sheshank.blog.repositories.CategoryRepo;
import com.sheshank.blog.services.CategoryServices;

@Service
public class CategoryServiceImple implements CategoryServices {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub

		if (categoryRepo.findByCategoryTitle(categoryDto.getCategoryTitle()) != null)
			throw new RuntimeException("Category Title already exists");

		Category category = dtoToCategory(categoryDto);

		Category savedCategory = categoryRepo.save(category);

		return categoryToDto(savedCategory);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		// TODO Auto-generated method stub

		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());

		Category updatedCategory = categoryRepo.save(category);
		CategoryDto categoryDto1 = categoryToDto(updatedCategory);
		return categoryDto1;
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

		return categoryToDto(category);
	}

	@Override
	public List<CategoryDto> getCategoriesList() {
		List<Category> categories = categoryRepo.findAll();
		List<CategoryDto> categoriesDto = categories.stream().map((category) -> categoryToDto(category))
				.collect(Collectors.toList());

		return categoriesDto;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub

		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

		this.categoryRepo.delete(category);

	}

	private Category dtoToCategory(CategoryDto categoryDto) {
		Category category = modelMapper.map(categoryDto, Category.class);
		return category;
	}

	public CategoryDto categoryToDto(Category category) {
		CategoryDto categortDto = modelMapper.map(category, CategoryDto.class);
		return categortDto;
	}

}
