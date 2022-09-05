package com.sheshank.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheshank.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
