package com.springsecurity01.service;

import java.util.List;

import com.springsecurity01.config.UserPrincipal;
import com.springsecurity01.dto.UserDTO;
import com.springsecurity01.entity.User;

public interface UserService {
	User createUser(User user);

	UserPrincipal findByUsername(String username);

	List<UserDTO> GetAll();

	void Save(UserDTO user);

	void Update(UserDTO user);

	void Delete(String Username);
	
	User findUser(String username);

}
