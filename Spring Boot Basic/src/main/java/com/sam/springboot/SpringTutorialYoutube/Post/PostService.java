package com.sam.springboot.SpringTutorialYoutube.Post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sam.springboot.SpringTutorialYoutube.Location.Location;
import com.sam.springboot.SpringTutorialYoutube.User.User;

@Service
public class PostService {
	User user1 = new User("u1", "sam", "man", new Location("l1", "Mangalore"), "sam@gmail.com");
	User user2 = new User("u2", "stpn", "manohar", new Location("l2", "Bangalore"), "stpn@gmail.com");

	Post post1 = new Post("p1", "04-Dec-22", user1, "Birthday");
	Post post2 = new Post("p2", "25-Dec-23", user2, "Christmas");

	List<Post> posts = new ArrayList<>(Arrays.asList(post1, post2));

	public List<Post> getAllPost() {
		return posts;
	}

	public Post getPost(String id) {
		Post post = posts.stream().filter(p -> id.equals(p.getId())).findFirst().orElse(null);
		return post;
	}

	public void addPost(Post post) {
		posts.add(post);
	}

	public void updatePost(Post post, String id) {
		for(int i=0;i<posts.size();i++) {
			Post p=posts.get(i);
			if(p.getId().equals(id)) {
				posts.set(i, post);
			}
		}
	}

	public void deletePost(String id) {
		posts.removeIf(p -> p.getId().equals(id));
	}
}
