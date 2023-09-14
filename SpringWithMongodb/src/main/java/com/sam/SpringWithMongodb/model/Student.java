package com.sam.SpringWithMongodb.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {

	@Id
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private Gender gender;
	private Address address;
	private List<String> favSubjects;
	private BigDecimal totalSpent;
	private LocalDateTime created;
	
	
	public Student() {}
	public Student(String firstname, String lastname, String email, Gender gender, Address address,
			List<String> favSubjects, BigDecimal totalSpent, LocalDateTime created) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.favSubjects = favSubjects;
		this.totalSpent = totalSpent;
		this.created = created;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getFavSubjects() {
		return favSubjects;
	}
	public void setFavSubjects(List<String> favSubjects) {
		this.favSubjects = favSubjects;
	}
	public BigDecimal getTotalSpent() {
		return totalSpent;
	}
	public void setTotalSpent(BigDecimal totalSpent) {
		this.totalSpent = totalSpent;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
}
