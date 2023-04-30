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
	
	//insert method for Student
	public void insertStudent(Student student) {
		
		dao.insertStudent(student);		
	}
	
	//get by Id
	public int getById(int id) {
		
		return id;
		
	}
	
	// delete by id
	public String deleteById(int id) {
		
		if(dao.getById(id) !=0) {
			dao.deleteById(id);
			return "Data.......... delete Successfully..";
		}else {
			return "Given id id not present";
		}
		
	}
	
	// update method
	public String updateStudent(Student student, int id) {
		
		if(dao.getById(id)!=0) {
			dao.updateStudent(student, id);
			
			return "Data ....... update successfully...";
		}else {
			return "Given id is not present";
		}
	}
	
	// display method
		public List<Student> displayAllStudent(){
			return dao.displayAllStudent();
		}
		
}
