package com.jsp.springbootonetooneunimorning.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springbootonetooneunimorning.dto.Person;
import com.jsp.springbootonetooneunimorning.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	// insert method--------------------------------------------------------------------------
	@PostMapping("/savePersonLaptop")
	public List<Object> insertPerson(@RequestBody Person person) {
		Person person2 = personService.insertPerson(person);
		
		List<Object> objects = new ArrayList<Object>(Arrays.asList(person2,person2.getLaptop()));
		return objects;
	}
	
	
	// getPersonLaptopById------------------------------------------------------------------------
	@GetMapping("/getPersonLaptopById/{personId}")
	public List<Object> getpersonLaptopById(@PathVariable int personId) {
		return personService.getpersonLaptopById(personId);
	}	
	
	// deletePersonLaptop------------------------------------------------------------------------
	@DeleteMapping("/deletePersonLaptop/{personId}")
	public String deletePersonLAptop(@PathVariable int personId) {
		return personService.deletePersonLAptop(personId);
	}	
	
	//updatePersonLaptopById----------------------------------------------------------------------
	@PutMapping("/updatePersonLaptop/{personId}")
	public Person updatePersonLaptopById( @RequestBody Person person, @PathVariable int personId) {
		return personService.updatePersonLaptopById(person, personId);
	}	
	
	// displayAllPersonLaptop-------------------------------------------------------------------
	@GetMapping("/getAllPersonLaptop")
	public List<Object> displyAllPersonLaptop(){
		List<Object> list = new ArrayList<Object>();
		List<Person> person = personService.displyAllPersonLaptop();

		
		for (Person person2 : person) {
			list.add(person2);
			list.add(person2.getLaptop());
		}
		return list;
	}	
}
