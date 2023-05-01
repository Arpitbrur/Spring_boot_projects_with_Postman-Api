package com.qsp.springbootcrud3pm.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity                                 // for table
public class Student {
	
	@Id                                // bcz table id is primary key
	private int studentId;
	private String studentName;
	private String studentEmail;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
	
}
