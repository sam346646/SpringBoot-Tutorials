package com.sam.springboot.SpringTutorialYoutube.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sam.springboot.SpringTutorialYoutube.model.User;

public interface UserRepository extends CrudRepository<User, String>{
	public List<User> findByLocationId(String locationId);
	public List<User> findByFirstname(String firstName);	
}
