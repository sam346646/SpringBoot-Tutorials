package com.sam.springboot.SpringTutorialYoutube.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
	
	@RequestMapping(value = "/user/{id}")
	public Optional<User> getUser(@PathVariable String id) {
		return userService.getUser(id);
	}
	
	@PostMapping(value = "/user/add")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PutMapping(value = "/user/update/{id}")
	public void updateUser(@RequestBody User user,@PathVariable String id) {
		userService.updateUser(user,id);
	}
	
	@DeleteMapping(value = "/user/delete/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
}
