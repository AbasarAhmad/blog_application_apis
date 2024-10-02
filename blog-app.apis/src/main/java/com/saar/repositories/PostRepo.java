package com.saar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saar.entities.Category;
import com.saar.entities.Post;
import com.saar.entities.User;

public interface PostRepo extends JpaRepository<Post,Integer> {
	List<Post>findByUser(User user);
	List<Post>findByCategory(Category category);
}
