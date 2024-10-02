package com.saar.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String description;
	
	// Post class mai Category ka object category bna huva hai , cascade mtlb agar parent ko hata dai to uske child bhi hat jaye,or agar parent ko add kr rahe hai to child ko alag se save na krna pade
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	private List<Post> posts=new ArrayList<>();
	
}
