package com.sam.backend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@GetMapping("/messages")
	public ResponseEntity<List<String>>  messages() {
		return ResponseEntity.ok(Arrays.asList("First","Second"));
	}
}
