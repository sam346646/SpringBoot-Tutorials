package com.sam.backend.config;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sam.backend.dto.UserDto;
import com.sam.backend.service.UserService;

import jakarta.annotation.PostConstruct;

@Component
public class UserAuthenticationProvider {
	
	@Autowired
	private UserService userService;

	@Value("${security.jwt.token.secret-key:secret-value}")
	private String secretKey;
	
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}
	
	
	public String createToken(String email) {
		Date now = new Date();
		Date validity = new Date(now.getTime() + 3_600_000);  //for 1 hour
		return JWT
				.create()
				.withIssuer(email)
				.withIssuedAt(now)
				.withExpiresAt(validity)
				.sign(Algorithm.HMAC256(secretKey));
	}
	
	public Authentication validateToken(String token) {
		JWTVerifier verifier= JWT.require(Algorithm.HMAC256(secretKey)).build();
		DecodedJWT decodedJWT=verifier.verify(token);
		
		UserDto user=userService.findByEmail(decodedJWT.getIssuer());
		
		return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
	}
	
}
