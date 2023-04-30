package com.qsp.springbootcrud3pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springbootcrud3pm.dto.Student;
import com.qsp.springbootcrud3pm.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	// insert Method for Student
	@PostMapping("/arpitInsert")
	public void insertStudent(@RequestBody Student student) {
		
		service.insertStudent(student);
		
	}
	//get by id
	@GetMapping("/getStudentId/{id}")
	public int getById(@PathVariable int id) {
		
		return service.getById(id);
		
	}
	
	//delete by id
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
	//update method 
	@PutMapping("/updateMapping/{id}")
	public String updateStudent(@RequestBody Student student, @PathVariable int id) {
		return service.updateStudent(student, id);
	}
	
	//display method
	@GetMapping("/displayAll")
		public List<Student> displayAllStudent(){
			return service.displayAllStudent();
		}
		

}
