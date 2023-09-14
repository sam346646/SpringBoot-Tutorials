package com.sam.SpringSecurity6JWTWithoutJDBC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.SpringSecurity6JWTWithoutJDBC.config.JwtUtils;
import com.sam.SpringSecurity6JWTWithoutJDBC.dao.UserDao;
import com.sam.SpringSecurity6JWTWithoutJDBC.dto.AuthenticationRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request) {	
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		final UserDetails userDetails = userDao.findUserByEmail(request.getEmail());
		if(userDetails!=null) {
			return ResponseEntity.ok(jwtUtils.generateToken(userDetails));		
		}
		return ResponseEntity.ok("Some error has occured");
	}
	
}
