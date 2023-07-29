package com.jsp.springbootonetooneunimorning.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
@Entity
public class Person {

	@Id
	private int personId;
	private String personName;
	private String personEmail;
	private String personLocation;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="laptopId")
	@JsonBackReference
	private Laptop laptop;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public String getPersonLocation() {
		return personLocation;
	}

	public void setPersonLocation(String personLocation) {
		this.personLocation = personLocation;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	
	
}
