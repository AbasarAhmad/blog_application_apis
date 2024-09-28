package com.saar.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saar.payloads.CategoryDto;

@Service
public interface CategoryService {
	
	// For Create Category in Database
	CategoryDto createCategory(CategoryDto categoryDto);
	
	// For update the category  
	CategoryDto updateCategory(CategoryDto categoryDto, Integer id);
	
	// for delete Catedory by I
	 
	void deleteCategory(Integer id);
	
	// get category by id
	CategoryDto getCategory(Integer id);
	
	// get all category
	List<CategoryDto> getCategories();
	}
