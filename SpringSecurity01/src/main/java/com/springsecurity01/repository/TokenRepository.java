package com.springsecurity01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity01.entity.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {
	Token findByToken(String token);
}
