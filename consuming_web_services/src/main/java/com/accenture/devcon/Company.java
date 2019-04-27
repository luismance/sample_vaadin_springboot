package com.accenture.devcon;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class Company {

	@NotEmpty
	private String name;

	@Email
	@NotEmpty
	private String email;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
