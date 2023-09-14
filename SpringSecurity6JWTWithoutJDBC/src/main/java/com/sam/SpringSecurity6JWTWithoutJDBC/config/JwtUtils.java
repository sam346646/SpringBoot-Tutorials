package com.sam.SpringSecurity6JWTWithoutJDBC.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

	private String secret_key = "secret";

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		final Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(secret_key).parseClaimsJws(token).getBody();
	}

	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(), userDetails);
	}

	public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
		return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
				.claim("authorities", userDetails.getAuthorities())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
				.signWith(SignatureAlgorithm.HS256, secret_key).compact();
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {
		String userEmail = extractUsername(token);
		return (userEmail.equals(userDetails.getUsername())) && !isTokenExpired(token);
	}

	private boolean isTokenExpired(String token) {
		return extractExporation(token).before(new Date());
	}

	private Date extractExporation(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
}
