package com.jsp.springbootonetooneunimorning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.jsp.springbootonetooneunimorning.dto.Person;
@Component
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
