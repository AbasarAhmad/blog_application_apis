package com.saar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saar.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>  {

}
