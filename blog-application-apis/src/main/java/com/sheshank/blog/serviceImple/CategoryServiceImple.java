package com.sheshank.blog.serviceImple;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheshank.blog.entities.Category;
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

		Category category = dtoToCategory(categoryDto);

		Category savedCategory = categoryRepo.save(category);

		return categoryToDto(savedCategory);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto category, Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDto> getCategoriesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub

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
