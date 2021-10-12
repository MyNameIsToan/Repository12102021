package com.springsecurity01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity01.entity.Token;
import com.springsecurity01.repository.TokenRepository;
import com.springsecurity01.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public Token createToken(Token token){
        return tokenRepository.saveAndFlush(token);
    }
    
    @Override
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }
    
    @Override
	public int remove(Token Token) {
		try{
			tokenRepository.delete(Token);
			return 0;
		}catch(Exception e) {
			return 1;
		}
	}
}