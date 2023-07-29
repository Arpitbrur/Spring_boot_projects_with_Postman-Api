package com.jsp.springbootonetooneunimorning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springbootonetooneunimorning.dao.PersonDao;
import com.jsp.springbootonetooneunimorning.dto.Laptop;
import com.jsp.springbootonetooneunimorning.dto.Person;

@Service
public class PersonService {

	@Autowired
	PersonDao personDao;
	
	// insert method-----------------------------------------------------
	public Person insertPerson(Person person) {
		return personDao.insertPerson(person);
	}
	
	// getPersonLaptopById------------------------------------------------------------------------
		public List<Object> getpersonLaptopById(int personId) {
			return personDao.getpersonLaptopById(personId);
	}	
		
	// deletePersonLaptop------------------------------------------------------------------
	public String deletePersonLAptop(int personId) {
		personDao.deletePersonLAptop(personId);
		if(personId != 0) {
			return "data deleted successfully";
		}else {
			return "given id is not found in database";
		}
	}
	
	//updatePersonLaptopById-------------------------------------------------------------------
	public Person updatePersonLaptopById(Person person, int personId) {
		return personDao.updatePersonLaptopById(person, personId);
	}	
	
	// displayAllPersonLaptop-------------------------------------------------------------------
	public List<Person> displyAllPersonLaptop(){
		return personDao.displyAllPersonLaptop();
	}	
}
