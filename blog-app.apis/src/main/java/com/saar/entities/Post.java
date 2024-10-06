package com.saar.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer postId;
	
	@Column(name="post_title",length=100,nullable=false)
	private String title;
	@Column(length=1000)
	private String content;
	private String imageName;
	private Date addDate;
	@ManyToOne
	@JoinColumn(name="category_id") // Here i changed join columns name
	private Category category;
	
	@ManyToOne
	private User user;

	@OneToMany(mappedBy="post",cascade=CascadeType.ALL)
	private Set<Comment>comments=new HashSet<>();
}
