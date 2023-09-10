package com.sam.springboot.SpringTutorialYoutube.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sam.springboot.SpringTutorialYoutube.model.Post;

public interface PostRepository extends CrudRepository<Post, String> {
	public List<Post> findByUserId(String userId);
}
