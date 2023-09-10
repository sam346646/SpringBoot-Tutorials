package com.sam.springboot.SpringTutorialYoutube.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Location extends Auditable<String>{
	
	@Id
	private String id;
	private String name;
	
	public Location() {
		super();
	}

	public Location(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
