package com.saar.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saar.entities.Comment;
import com.saar.entities.Post;
import com.saar.exceptions.ResourceNotFoundException;
import com.saar.payloads.CommentDto;
import com.saar.repositories.CommentRepo;
import com.saar.repositories.PostRepo;
import com.saar.services.CommentService;

@Service
public class CommentSeviceImpl implements CommentService {
	@Autowired
	CommentRepo commentRepo;
	
	@Autowired
	PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "post id" ,postId));
		Comment comment =this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment=this.commentRepo.save(comment);
		return modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comm =this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment", "comment id" ,commentId));
		this.commentRepo.delete(comm);

	}

}
