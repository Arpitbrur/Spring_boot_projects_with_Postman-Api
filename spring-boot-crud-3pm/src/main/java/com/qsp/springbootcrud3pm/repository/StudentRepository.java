package com.qsp.springbootcrud3pm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springbootcrud3pm.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
