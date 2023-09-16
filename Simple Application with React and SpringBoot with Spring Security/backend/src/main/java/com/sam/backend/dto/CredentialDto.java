package com.sam.backend.dto;

public class CredentialDto {
	
	private String email;
	private char[] password;
	
	
	public CredentialDto() {}
	public CredentialDto(String email, char[] password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
}