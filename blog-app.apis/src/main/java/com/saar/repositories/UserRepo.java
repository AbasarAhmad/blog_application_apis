package com.saar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saar.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>  {

}
