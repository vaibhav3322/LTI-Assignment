package com.vaibhav.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
