package com.sam.springboot.SpringTutorialYoutube.Post;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, String> {
	public List<Post> findByUserId(String userId);
}
