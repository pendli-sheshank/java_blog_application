package com.sheshank.blog.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer id;

	@NotEmpty(message = "Should not be empty")
	@Size(min = 2, message = "Atleast 2char should be there")
	private String categoryTitle;

	private String categoryDescription;

}
