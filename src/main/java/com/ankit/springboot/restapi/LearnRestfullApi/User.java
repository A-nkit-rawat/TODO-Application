package com.ankit.springboot.restapi.LearnRestfullApi;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	
	private int id;
	@Size(min=4, message="name can't be less than 4 character")
	private String name;
	@NotNull(message="You have not inserted any date !")
	@Past (message="Future or present date not allowed !")
	private LocalDate dob;
	
	
	public User(int id,String name, LocalDate dob) {
		this.id=id;
		this.name = name;
		this.dob = dob;
	}
	
	public  int getId() {
		return id;
	}
	public  void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	
	
	
}
