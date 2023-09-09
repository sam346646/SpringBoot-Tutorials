package com.sam.springboot.SpringTutorialYoutube.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sam.springboot.SpringTutorialYoutube.Location.Location;

@Service
public class UserService {

	User user1 = new User("u1", "sam", "man", new Location("l1", "Mangalore"), "sam@gmail.com");
	User user2 = new User("u2", "stpn", "manohar", new Location("l2", "Bangalore"), "stpn@gmail.com");

	List<User> users = new ArrayList<>(Arrays.asList(user1, user2));

	public List<User> getAllUser() {
		return users;
	}

	public User getUser(String id) {
		User user = users.stream().filter(u -> id.equals(u.getId())).findFirst().orElse(null);
		return user;
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void updateUser(User user, String id) {
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if (u.getId().equals(id)) {
				users.set(i, user);
			}
		}
	}

	public void deleteUser(String id) {
		users.removeIf(u -> u.getId().equals(id));
	}
}
