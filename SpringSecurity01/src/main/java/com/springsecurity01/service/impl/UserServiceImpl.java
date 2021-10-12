package com.springsecurity01.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity01.config.UserPrincipal;
import com.springsecurity01.dto.UserDTO;
import com.springsecurity01.entity.User;
import com.springsecurity01.repository.UserRepository;
import com.springsecurity01.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
    	User userentity = userRepository.findByUsername(user.getUsername());
		if(userentity == null) {
			return userRepository.saveAndFlush(user);
		}
		return null;
    }
    
    @Override
    public UserPrincipal findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        UserPrincipal userPrincipal = new UserPrincipal();
        if (null != user) {
            Set<String> authorities = new HashSet<>();
            if (null != user.getRoles()) user.getRoles().forEach(r -> {
                authorities.add(r.getRoleKey());
                r.getPermissions().forEach(p -> authorities.add(p.getPermissionKey()));
            });

            userPrincipal.setUserId(user.getId());
            userPrincipal.setUsername(user.getUsername());
            userPrincipal.setPassword(user.getPassword());
            userPrincipal.setAuthorities(authorities);
        }
        return userPrincipal;
    }
    
	@Override
	public List<UserDTO> GetAll() {
		List<UserDTO> ListOfUserDTO = new ArrayList<>();
		List<User> ListOfUserEntity = userRepository.findAll();
		for(User item : ListOfUserEntity) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUsername(item.getUsername());
			userDTO.setPassword(item.getPassword());
			userDTO.setFirstname(item.getFirstname());
			userDTO.setLastname(item.getLastname());
			userDTO.setEmail(item.getEmail());
			ListOfUserDTO.add(userDTO);
		}
		return ListOfUserDTO;
	}

	@Override
	public void Save(UserDTO user) {
		User userentity = new User();
		userentity.setUsername(user.getUsername());
		userentity.setPassword(user.getPassword());
		userentity.setEmail(user.getEmail());
		userentity.setFirstname(user.getFirstname());
		userentity.setLastname(user.getLastname());
		userRepository.save(userentity);
	}

	@Override
	public void Update(UserDTO user) {
		User userentity = userRepository.findByUsername(user.getUsername());
		userentity.setPassword(user.getPassword());
		userentity.setEmail(user.getEmail());
		userentity.setFirstname(user.getFirstname());
		userentity.setLastname(user.getLastname());
		userRepository.save(userentity);
	}

	@Override
	public void Delete(String Username) {
		User userentity = userRepository.findByUsername(Username);
		if(userentity != null) {
			userRepository.delete(userentity);
		}
	}

	@Override
	public User findUser(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}
}
