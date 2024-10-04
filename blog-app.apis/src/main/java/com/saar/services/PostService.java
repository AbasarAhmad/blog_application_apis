package com.saar.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saar.entities.Post;
import com.saar.payloads.PostDto;

@Service
public interface PostService {

	// create Post
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	// Update Post
	PostDto updatePost(PostDto postDto, Integer postId);
	
	// Delete Post
	void deletePost(Integer postId);
	
	// get all posts
	
	List<PostDto>getAllPost(Integer pageNumber, Integer pageSize);
	
	// get Single post
	PostDto getPostById(Integer postId);
	
	// get all posts by category
	List<PostDto>getPostsByCategory(Integer categoryId);
	
	// get all posts by user
	List<PostDto>getPostsByUser(Integer userId);
	
	List<Post>searchPosts(String keyword);
}
