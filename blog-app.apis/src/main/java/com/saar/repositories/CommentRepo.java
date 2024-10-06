package com.saar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saar.entities.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
