package com.sam.SpringSecurity6JWTWithoutJDBC.dao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	private final static List<UserDetails> APPLICATION_USER = Arrays.asList(
			new User("sam@gmail.com", "pass", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))),
			new User("stpn@gmail.com", "pass", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))));

	public UserDetails findUserByEmail(String email) {
		return APPLICATION_USER
				   .stream()
				   .filter(u -> u.getUsername().equals(email))
				   .findFirst()
				   .orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}
}
