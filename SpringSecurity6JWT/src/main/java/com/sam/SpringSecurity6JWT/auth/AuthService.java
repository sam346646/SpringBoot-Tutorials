package com.sam.SpringSecurity6JWT.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sam.SpringSecurity6JWT.config.JwtService;
import com.sam.SpringSecurity6JWT.user.Role;
import com.sam.SpringSecurity6JWT.user.User;
import com.sam.SpringSecurity6JWT.user.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;

	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager; 

	public AuthenticationResponse register(RegisterRequest request) {
			var user= User.builder()
					  .firstname(request.getFirstname())
					  .lastname(request.getLastname())
					  .email(request.getEmail())
					  .password(passwordEncoder.encode(request.getPassword()))
					  .role(Role.USER)
					  .build();
		userRepository.save(user);
		var jwtToken=jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		var user= userRepository.findByEmail(request.getEmail())
				                .orElseThrow();
		var jwtToken=jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	
	
}
