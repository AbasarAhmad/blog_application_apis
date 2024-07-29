package com.saar.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.saar.entities.User;
import com.saar.payloads.UserDto;
import com.saar.repositories.UserRepo;
import com.saar.services.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto); // here we change Dto to user
		User savedUser=this.userRepo.save(user); // Here we Save user;
		return this.userToDto(savedUser); // Herer we access Saved User
	}

	@Override
	public UserDto updateUser(UserDto user, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

	}
	
	// Here we change UserDto to User , means we store data in user through Dto  means we store data
	private User dtoToUser (UserDto userDto)
	{
		User user=new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPasssword());
		return user;
	}
	
// Here we Change user to Dto , means we access data from user, means we take data from dto to user
	public UserDto userToDto (User user)
	{
		UserDto userDto= new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setAbout(user.getAbout());
		userDto.setPasssword(user.getPassword());
		return userDto;
	}
	


}
