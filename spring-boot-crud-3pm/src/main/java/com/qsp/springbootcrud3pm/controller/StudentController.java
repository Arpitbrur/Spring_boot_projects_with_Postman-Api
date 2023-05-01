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
	StudentService studentService;
	
	// insert Method-------------------------------------------------------------------
	@PostMapping("/insertStudent")
		public Student insertStudent(@RequestBody Student student) {	
			return studentService.insertStudent(student);
		
	}
	
	//get by id------------------------------------------------------------------------
	@GetMapping("/getByIdStudent/{studentId}")
	public Student getByIdStudent(@PathVariable int studentId) {
		Student student = studentService.getByIdStudent(studentId);
		return student;
		
	}
	
	//delete by id----------------------------------------------------------------------
	@DeleteMapping("/deleteStudent/{studentId}")
	public String deleteById(@PathVariable int studentId) {
		return studentService.deleteById(studentId);
		
	}
	
	//update method--------------------------------------------------------------------- 
	@PutMapping("/updateStudent/{studentId}")
	public String updateStudent(@RequestBody Student student, @PathVariable int studentId) {
		return studentService.updateStudent(student, studentId);
		
	}
	
	//display method--------------------------------------------------------------------
	@GetMapping("/displayAllStudent")
	public List<Student> displayAllStudent(){
		return studentService.displayAllStudent();
		
	}
		

}
