package com.sheshank.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheshank.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	
	Category findByCategoryTitle(String categoryTitle);

}
