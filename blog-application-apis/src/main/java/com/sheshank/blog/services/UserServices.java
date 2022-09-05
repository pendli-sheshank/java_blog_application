package com.sheshank.blog.services;

import java.util.List;

import com.sheshank.blog.payloads.UserDto;

public interface UserServices {
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);

}
 