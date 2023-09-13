package com.sam.SpringSecurity6JWT.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
	
	
	
	private String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(), userDetails);
	}

	private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
		return Jwts
			   .builder()
			   .setClaims(extraClaims)
			   .setSubject(userDetails.getUsername())
			   .setIssuedAt(new Date(System.currentTimeMillis()))
			   .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
			   .signWith(getSignInKey(),SignatureAlgorithm.HS256)
			   .compact();
	}
	
	public boolean isTokenValid(String token, UserDetails userDetails) {
		String userEmail= extractUsername(token);
		return (userEmail.equals(userDetails.getUsername())) && !isTokenExpired(token); 
	}

	private boolean isTokenExpired(String token) {
		return extractExporation(token).before(new Date());
	}

	private Date extractExporation(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	
}
