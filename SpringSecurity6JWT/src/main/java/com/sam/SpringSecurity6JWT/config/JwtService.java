package com.sam.SpringSecurity6JWT.config;

import java.security.Key;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	private String secret_key="pEFjwzWL+PP1lXYyxlhkAAEjgqBZquCTEb/dgGlhPjkQI/TmvoTFnXIo0azdXr73";

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		final Claims claims=extractAllClaims(token);
		return claimResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts
			   .parserBuilder()
			   .setSigningKey(getSignInKey())
			   .build()
			   .parseClaimsJws(token)
			   .getBody();
	}

	private Key getSignInKey() {
		final byte[] keyBytes=Decoders.BASE64.decode(secret_key);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
}
