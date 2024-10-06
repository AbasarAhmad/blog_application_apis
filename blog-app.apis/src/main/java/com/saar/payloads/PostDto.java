package com.saar.payloads;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.saar.entities.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	private Integer postId;
	private String title;
	private String content;
	private String imageName;
	private Date addDate;
	private CategoryDto category; // CategoryDto is liye likhe hai taki recursion ka situation na bane
	private UserDto user;
	private Set<CommentDto>comments =new HashSet<>();
}
