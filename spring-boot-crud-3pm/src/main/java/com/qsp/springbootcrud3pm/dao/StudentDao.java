package com.qsp.springbootcrud3pm.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springbootcrud3pm.dto.Student;
import com.qsp.springbootcrud3pm.repository.StudentRepository;

@Repository
public class StudentDao {

	@Autowired            // it is use to create a object.
	StudentRepository studentRepository;
	
	//insert method-----------------------------------------------------------------
	public Student insertStudent(Student student) {	
		return studentRepository.save(student);
	}
	
	// getById----------------------------------------------------------------------
	public Student getByIdStudent(int studentId) {
		Optional<Student> optional = studentRepository.findById(studentId);
		
		if(optional.isPresent()){
			Student student = optional.get();
			return student;
		}else {
			return null;
		}
	}
	
	
	//deleteById--------------------------------------------------------------------
	public int deleteById(int studentId) {
		Optional<Student> optional= studentRepository.findById(studentId);
		
		if(optional.isPresent()) {
			Student student=optional.get();
			int studentId1 = optional.get().getStudentId();
			studentRepository.delete(student);
			return studentId1;	
		}
		return 0;
		
	}
	
	//update Student-----------------------------------------------------------------
	public void updateStudent(Student student, int studentId) {
		
		Optional<Student> optional = studentRepository.findById(studentId);
		Student student1 = optional.get();
		if(optional.isPresent()) {
			
			if((student.getStudentName() != null) && (student.getStudentEmail() != null)) {
				student1.setStudentName(student.getStudentName());
				student1.setStudentEmail(student.getStudentEmail());				
				studentRepository.save(student1);
				
			}else if(student.getStudentName() !=null) {
				student1.setStudentName(student.getStudentName());
				studentRepository.save(student1);
			}else {
				student1.setStudentEmail(student.getStudentEmail());
				studentRepository.save(student1);
			}	
			
		}
	}
	
	
	// display method------------------------------------------------------------------
	public List<Student> displayAllStudent(){
		return studentRepository.findAll();
	}
	
}
