package com.sam.SpringTestTechademy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.SpringTestTechademy.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{
	
}
