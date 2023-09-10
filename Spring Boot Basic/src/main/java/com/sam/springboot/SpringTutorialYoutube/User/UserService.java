package com.sam.springboot.SpringTutorialYoutube.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> getAllUser() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public Optional<User> getUser(String id) {
		return userRepository.findById(id);
	}

	public List<User> findUsersByLocation(String locationId) {
		List<User> users = new ArrayList<>();
		userRepository.findByLocationId(locationId).forEach(users::add);
		return users;
	}

	public List<User> findUserByFirstName(String firstName){
		List<User> users= new ArrayList<>();
		userRepository.findByFirstname(firstName).forEach(users::add);
		return users;
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user, String id) {
		userRepository.save(user);
	}

	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
}
