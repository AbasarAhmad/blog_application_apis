package com.saar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saar.payloads.UserDto;
import com.saar.payloads.ApiResponse;
import com.saar.repositories.UserRepo;
import com.saar.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// POST - create  user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto createUserDto=this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED );
	}
	
	// PUT  -  update user
	@PutMapping("/{userId}") // PathVariable use for fetch the value, jaisa ki userId fetch krne
//	ke liye PathVariable ka use kiye hai Integer type ka value jiska naam userId hai
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId)
	{
		UserDto updatUserDto=this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatUserDto);
	}
	
	
	// DELETE  -   delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser( @PathVariable("userId") Integer uId)
	{
		this.userService.deleteUser(uId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User has been deleted",true),HttpStatus.OK);
	}
	
	//GET   -   user get
	// get a single user
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getsingleUser(@PathVariable Integer userId)
	{
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
	// get all user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>>getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUser());
	}
}
