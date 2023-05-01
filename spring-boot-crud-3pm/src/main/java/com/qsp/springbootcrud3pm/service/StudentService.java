package com.qsp.springbootcrud3pm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.springbootcrud3pm.dao.StudentDao;
import com.qsp.springbootcrud3pm.dto.Student;
@Service
public class StudentService {
	@Autowired
	StudentDao dao;
	
	//insert method-----------------------------------------------------------------
		public Student insertStudent(Student student) {	
			return dao.insertStudent(student);		
	}
	
	//get by Id---------------------------------------------------------------------
	public Student getByIdStudent(int studentId) {
		return dao.getByIdStudent(studentId);
				
	}
	
	// delete by id
	public String deleteById(int studentId) {
		
		if(dao.getByIdStudent(studentId) != null) {
			dao.deleteById(studentId);
			return "Data deleted successfully..................";
		}else {
			return " Given id is not present in database...........";
		}
		
	}
	
	// update method----------------------------------------------------------------
	public String updateStudent(Student student, int studentId) {
		
		if(dao.getByIdStudent(studentId) != null) {
			dao.updateStudent(student, studentId);			
			return "Data updated successfully..............";
		}else {
			return "Given id is not present in database............";
		}
	}
	
	// display method----------------------------------------------------------------
		public List<Student> displayAllStudent(){
			return dao.displayAllStudent();
		}
		
}
