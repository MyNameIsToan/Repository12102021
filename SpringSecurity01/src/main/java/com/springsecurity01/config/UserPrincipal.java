package com.springsecurity01.config;

import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserPrincipal implements UserDetails{
	private Long userId;
    private String username;
    private String password;
    private Collection authorities;

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
