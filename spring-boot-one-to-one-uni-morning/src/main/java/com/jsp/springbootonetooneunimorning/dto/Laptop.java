package com.jsp.springbootonetooneunimorning.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Laptop {

	@Id
	private int laptopId;
	private String laptopName;
	private String laptopColor;

	@OneToOne(mappedBy = "laptop",cascade = CascadeType.ALL)
	@JsonBackReference
	private Person person;

	public int getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public String getLaptopColor() {
		return laptopColor;
	}

	public void setLaptopColor(String laptopColor) {
		this.laptopColor = laptopColor;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
