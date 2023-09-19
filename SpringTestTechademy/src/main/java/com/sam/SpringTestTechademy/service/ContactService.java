package com.sam.SpringTestTechademy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.SpringTestTechademy.model.Contact;
import com.sam.SpringTestTechademy.repo.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	public Contact add(Contact contact) {
		return contactRepository.save(contact);
	}

}
