package com.springsecurity01.config;

import java.text.ParseException;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.springsecurity01.entity.User;

import net.minidev.json.JSONObject;

@Component
public class JwtUtil {

    private static final String USER = "user";
    private static final String SECRET = "daycaidaynaychinhlachukycuabandungdelorangoaidaynhenguyhiemchetnguoidayhihihi";

    public String generateToken(UserPrincipal user) {
        String token = null;
        try {
            JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
            UserPrincipal TokenUser = new UserPrincipal();
            TokenUser.setUsername(user.getUsername());
            TokenUser.setAuthorities(user.getAuthorities());
            builder.claim(USER, TokenUser);
            builder.expirationTime(generateExpirationDate());
            JWTClaimsSet claimsSet = builder.build();
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            JWSSigner signer = new MACSigner(SECRET.getBytes());
            signedJWT.sign(signer);
            token = signedJWT.serialize();
        } catch (Exception e) {
           e.getMessage();
        }
        return token;
    }

    public Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + 1800000);
    }
    
    private JWTClaimsSet getClaimsFromToken(String token) {
        JWTClaimsSet claims = null;
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(SECRET.getBytes());
            if (signedJWT.verify(verifier)) {
				claims = signedJWT.getJWTClaimsSet();
            }
        } catch (ParseException | JOSEException e) {
            
        }
        return claims;
    }

    public UserPrincipal getUserFromToken(String token) {
        UserPrincipal user = null;
        try {
            JWTClaimsSet claims = getClaimsFromToken(token);
            if (claims != null && isTokenExpired(claims)) {
                JSONObject jsonObject = (JSONObject) claims.getClaim(USER);
                user = new ObjectMapper().readValue(jsonObject.toJSONString(), UserPrincipal.class);
            }
        } catch (Exception e) {
           e.getMessage();
        }
        return user;
    }

    private Date getExpirationDateFromToken(JWTClaimsSet claims) {
        return claims != null ? claims.getExpirationTime() : new Date();
    }

    private boolean isTokenExpired(JWTClaimsSet claims) {
        return getExpirationDateFromToken(claims).after(new Date());
    }

}