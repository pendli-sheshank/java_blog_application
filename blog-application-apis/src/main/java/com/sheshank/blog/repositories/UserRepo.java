package com.sheshank.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheshank.blog.entities.User;
import com.sheshank.blog.payloads.UserDto;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	
	 boolean existsByEmail(String email);
	
}
