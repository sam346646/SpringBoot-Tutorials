package com.sam.backend.dto;

import com.sam.backend.model.User;

public class UserDto {
	
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String token;
	
	
	public UserDto() {}
	public UserDto(Long id, String firstname, String lastname, String email, String token) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.token = token;
	}
	//Convert User to UserDto
	public UserDto(User user) {
		this.id=user.getId();
		this.firstname=user.getFirstname();
		this.lastname=user.getLastname();
		this.email=user.getEmail();
		this.token=user.getPassword();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
