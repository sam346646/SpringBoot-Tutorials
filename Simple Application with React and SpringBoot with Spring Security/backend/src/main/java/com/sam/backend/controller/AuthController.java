package com.sam.backend.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sam.backend.config.UserAuthenticationProvider;
import com.sam.backend.dto.CredentialDto;
import com.sam.backend.dto.SignUpDto;
import com.sam.backend.dto.UserDto;
import com.sam.backend.service.UserService;

@RestController
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserAuthenticationProvider userAuthenticationProvider;
	
	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody CredentialDto credentialDto) {
		UserDto userDto=userService.login(credentialDto);
		userDto.setToken(userAuthenticationProvider.createToken(userDto.getEmail()));
		return ResponseEntity.ok(userDto);
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> register(@RequestBody SignUpDto signUpDto) {
		UserDto userDto=userService.register(signUpDto);
		userDto.setToken(userAuthenticationProvider.createToken(userDto.getEmail()));
		return ResponseEntity.created(URI.create("/users/"+userDto.getId())).body(userDto);
	}
}