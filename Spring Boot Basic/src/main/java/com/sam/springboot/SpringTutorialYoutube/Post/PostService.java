package com.sam.springboot.SpringTutorialYoutube.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	public List<Post> getAllPost() {
		List<Post> posts = new ArrayList<>();
		postRepository.findAll().forEach(posts::add);
		return posts;
	}

	public Optional<Post> getPost(String id) {
		return postRepository.findById(id);
	}

	public void addPost(Post post) {
		postRepository.save(post);
	}

	public void updatePost(Post post, String id) {
		postRepository.save(post);
	}

	public void deletePost(String id) {
		postRepository.deleteById(id);
	}
}
