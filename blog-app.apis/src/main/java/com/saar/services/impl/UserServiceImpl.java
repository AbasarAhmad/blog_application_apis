package com.saar.services.impl;

import com.saar.entities.User;
import com.saar.exceptions.ResourceNotFoundException;
import com.saar.payloads.UserDto;
import com.saar.repositories.UserRepo;
import com.saar.services.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private ModelMapper modelMapper;
    // creating user and store in database
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto); // Convert Dto to User
        User savedUser = this.userRepo.save(user); // Save User
        return this.userToDto(savedUser); // Convert saved User to Dto
    }

    // Update data of user by user id
    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        // Fetch user by ID
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPasssword());
        user.setAbout(userDto.getAbout());

        User updatedUser = this.userRepo.save(user); // Save updated user
        return this.userToDto(updatedUser);
    }

    // fetch user data by user id
    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        return this.userToDto(user);
    }

    // Find all the user
    @Override
    public List<UserDto> getAllUser() {
        List<User> users = this.userRepo.findAll();
        return users.stream().map(this::userToDto).collect(Collectors.toList());
    }

    // Use for delete user 
    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        this.userRepo.delete(user);
    }

    // Convert UserDto to User
    private User dtoToUser(UserDto userDto) {
//        User user = new User();
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setAbout(userDto.getAbout());
//        user.setPassword(userDto.getPasssword());
//        return user;
    	
    	// Now we will do same thing with help of modelMapper method
    	
    	User user=this.modelMapper.map(userDto, User.class); // userDto ko User.class mai change kr dega
    	return user;
    }

    // Convert User to UserDto
    public UserDto userToDto(User user) {
    	
    	UserDto userDto=this.modelMapper.map(user, UserDto.class);
    	
    	//Another way , to do the same work
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setAbout(user.getAbout());
//        userDto.setPasssword(user.getPassword());
        return userDto;
    }
}
