package com.jsp.Spring_simple_crud_project_morning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;

import com.jsp.Spring_simple_crud_project_morning.dto.Mobile;
@Component

public interface MobileRepository extends JpaRepository<Mobile, Integer>  {

}
