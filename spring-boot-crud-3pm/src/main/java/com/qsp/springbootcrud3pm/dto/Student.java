package com.qsp.springbootcrud3pm.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity                                 // for table
public class Student {
	@Id                                // bcz table id is primary key
	private int id;
	private String Name;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
