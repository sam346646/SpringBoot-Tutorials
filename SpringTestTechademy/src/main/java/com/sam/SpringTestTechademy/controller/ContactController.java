package com.sam.SpringTestTechademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sam.SpringTestTechademy.model.Contact;
import com.sam.SpringTestTechademy.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@PostMapping("/")
	public Contact addContact(@RequestBody Contact contact) {
		return contactService.add(contact);
	}
	
	
}
