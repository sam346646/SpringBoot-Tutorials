package com.sam.backend.service;

import java.nio.CharBuffer;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sam.backend.dto.CredentialDto;
import com.sam.backend.dto.SignUpDto;
import com.sam.backend.dto.UserDto;
import com.sam.backend.exception.AppException;
import com.sam.backend.model.User;
import com.sam.backend.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserDto findByEmail(String email) {
		User user=userRepository.findByEmail(email).orElseThrow(()->new AppException("Unknown user",HttpStatus.NOT_FOUND));
		return new UserDto(user);
	}
	
	public UserDto login(CredentialDto credentialDto) {
		User user=userRepository.findByEmail(credentialDto.getEmail()).orElseThrow(()->new AppException("Unknown user",HttpStatus.NOT_FOUND));
		if(passwordEncoder.matches(CharBuffer.wrap(credentialDto.getPassword()), user.getPassword())) {
			return new UserDto(user);
		}
		throw new AppException("Invalid Password", HttpStatus.BAD_REQUEST);
	}
	
	public UserDto register(SignUpDto signUpDto) {
		Optional<User> user=userRepository.findByEmail(signUpDto.getEmail());
		
		if(user.isPresent()) {
			throw new AppException("Email already exists.", HttpStatus.BAD_REQUEST);
		}
		User usr=new User(signUpDto);
		
		usr.setPassword(passwordEncoder.encode(CharBuffer.wrap(signUpDto.getPassword())));
		
		User savedUser=userRepository.save(usr);
		
		return new UserDto(savedUser);
	}
}
