package com.sam.springboot.SpringTutorialYoutube.Post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/post")
	public List<Post> getAllPost() {
		return postService.getAllPost();
	}
	
	@RequestMapping(value = "/post/{id}")
	public Post getPost(@PathVariable String id) {
		return postService.getPost(id);
	}
	
	@PostMapping(value = "/post/add")
	public void addPost(@RequestBody Post post) {
		postService.addPost(post);
	}
	
	@PutMapping(value = "/post/update/{id}")
	public void updatePost(@RequestBody Post post,@PathVariable String id) {
		postService.updatePost(post,id);
	}
	
	@DeleteMapping(value = "/post/delete/{id}")
	public void deletePost(@PathVariable String id) {
		postService.deletePost(id);
	}
}
