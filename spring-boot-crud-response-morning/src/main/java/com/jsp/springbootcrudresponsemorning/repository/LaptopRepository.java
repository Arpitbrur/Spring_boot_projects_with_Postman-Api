package com.jsp.springbootcrudresponsemorning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;

import com.jsp.springbootcrudresponsemorning.dto.Laptop;

@Component
public interface LaptopRepository extends JpaRepository<Laptop, Integer>{

}
