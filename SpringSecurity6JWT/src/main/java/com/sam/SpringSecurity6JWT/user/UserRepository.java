package com.sam.SpringSecurity6JWT.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> fingByEmail(String email);

}
