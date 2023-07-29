package com.jsp.springbootonetooneunimorning.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springbootonetooneunimorning.dto.Laptop;
import com.jsp.springbootonetooneunimorning.dto.Person;
import com.jsp.springbootonetooneunimorning.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	PersonRepository personRepository;
	
	// insert method-----------------------------------------------------------------------------
	public Person insertPerson(Person person) {
		return personRepository.save(person);
	}
	
	// getPersonLaptopById------------------------------------------------------------------------
	public List<Object> getpersonLaptopById(int personId) {
		
		List<Object> list = new ArrayList<Object>();
		Optional<Person> optional = personRepository.findById(personId);
		
		if(optional.isPresent()) {
			Person person = optional.get();
			Laptop laptop = person.getLaptop();
			
			list.add(person);
			list.add(laptop);
			return list;
		}else {
			return null;
		}
	}
	
	// deletePersonLaptop------------------------------------------------------------------
	public int deletePersonLAptop(int personId) {
		Optional<Person> optional = personRepository.findById(personId);
		if(optional.isPresent()) {
			Person person = optional.get();
			int person1 = optional.get().getPersonId();
			personRepository.delete(person);
			return person1;
		}else {
			return 0;
		}
		
	}
	
	//updatePersonLaptopById-------------------------------------------------------------------
	public Person updatePersonLaptopById(Person person, int personId) {
		Optional<Person> optional = personRepository.findById(personId);
		
		Person person2= optional.get();
		if((person.getPersonName()!=null) && (person.getPersonEmail()!=null) && (person.getPersonLocation()!=null) && (person.getLaptop()!=null)) {
			person2.setPersonName(person.getPersonName());
			person2.setPersonEmail(person.getPersonEmail());
			person2.setPersonLocation(person.getPersonLocation());
			person2.setLaptop(person.getLaptop());
			
			return personRepository.save(person2);
			
		}else {
			return null;
		}
	}
	
	// displayAllPersonLaptop-------------------------------------------------------------------
	public List<Person> displyAllPersonLaptop(){
		return personRepository.findAll();
	}
}
