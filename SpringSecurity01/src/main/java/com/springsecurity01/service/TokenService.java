package com.springsecurity01.service;

import com.springsecurity01.entity.Token;

public interface TokenService {
	Token createToken(Token token);
	Token findByToken(String token);
	int remove(Token Token);
}
