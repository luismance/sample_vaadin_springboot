package com.accenture.devcon;

import javax.validation.constraints.NotEmpty;

public class Employee {

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotEmpty
	private String position;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(@NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String position) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
