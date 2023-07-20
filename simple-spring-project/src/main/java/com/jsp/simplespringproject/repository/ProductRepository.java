package com.jsp.simplespringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;

import com.jsp.simplespringproject.dto.Product;

@Component
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
