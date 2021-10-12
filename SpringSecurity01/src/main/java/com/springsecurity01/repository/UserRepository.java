package com.springsecurity01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity01.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}