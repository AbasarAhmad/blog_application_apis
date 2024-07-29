package com.saar.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name="users") // ab hamara table users naame se banegi, agar isko nhi likhte to mera entity User ( class name ) se banti
@NoArgsConstructor
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	
	 @Column(name="user_name", nullable=false, length=100)
	private String name;

	private String email;
	 
	private String password;
	 
	private String about;
}
