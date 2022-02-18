package com.learning.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

import lombok.Data;

@Data

public class SignupRequest {
	@NotBlank
	@Size(min = 3, max = 20)
	private String username;

	@NotBlank
	@Size(min = 3, max = 20)
	private String name;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(min = 6, max = 100)
	private String password;
	
	//@NotBlank
	@Size(min = 3, max = 100)
	private String address;
	
	private Set<String> role;

}