package com.saar.services.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saar.entities.Category;
import com.saar.exceptions.ResourceNotFoundException;
import com.saar.payloads.CategoryDto;
import com.saar.repositories.CategoryRepo;
import com.saar.services.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(addedCat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
        Category cat = this.categoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category id", id));

        cat.setTitle(categoryDto.getTitle());
        cat.setDescription(categoryDto.getDescription());

        Category updatedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(updatedCat, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category cat = this.categoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category id", id));
        this.categoryRepo.delete(cat);
    }

    @Override
    public CategoryDto getCategory(Integer id) {
        Category cat = this.categoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category id", id));
        return this.modelMapper.map(cat, CategoryDto.class);  // Fixed mapping to CategoryDto
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        return categories.stream()
                .map(cat -> this.modelMapper.map(cat, CategoryDto.class))
                .collect(Collectors.toList());
    }
}
