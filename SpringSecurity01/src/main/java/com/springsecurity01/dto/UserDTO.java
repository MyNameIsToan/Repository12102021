package com.springsecurity01.dto;

import lombok.Data;

@Data
public class UserDTO {
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
}
