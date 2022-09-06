package com.sheshank.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;

	@NotEmpty
	@Size(min = 4, message = "Name should not be empty")
	private String name;

	@Email(message = "Enter valid email address")
	private String email;

	@NotEmpty
	@Size(min = 8, message = "Password should between 8-10 char")
	private String password;

	@NotEmpty(message = "About should not be null")
	private String about;

}
