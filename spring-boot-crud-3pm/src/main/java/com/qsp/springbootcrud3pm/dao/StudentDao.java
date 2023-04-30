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
	StudentRepository repository;
	
	//insert method for Student
	public void insertStudent(Student student) {	
		repository.save(student);
	}
	
	//getId
	public int getById(int id) {
		Optional<Student> optional = repository.findById(id);
		
		if(optional.isPresent()){
			return optional.get().getId();
		}else {
			return 0;
		}
	}
	
	
	//delete by Id
	public void deleteById(int id) {
		Optional<Student> optional= repository.findById(id);
		
		if(optional.isPresent()) {
			Student student=optional.get();
			
			repository.delete(student);
		}
	}
	
	//update Student
	public void updateStudent(Student student, int id) {
		
		Optional<Student> optional = repository.findById(id);
		Student student2 = optional.get();
		if(optional.isPresent()) {
			
			if((student.getName()!= null) && (student.getEmail() != null)) {
				student2.setEmail(student.getEmail());
				student2.setName(student.getName());
				
				repository.save(student2);
				
			}else if(student.getName() !=null) {
				student2.setName(student.getName());
				repository.save(student2);
			}else {
				student2.setEmail(student.getEmail());
				repository.save(student2);
			}	
			
		}
	}
	
	
	// display method
	public List<Student> displayAllStudent(){
		return repository.findAll();
	}
}
