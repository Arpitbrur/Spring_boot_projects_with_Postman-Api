package com.jsp.springbootcrudresponsemorning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springbootcrudresponsemorning.dto.Laptop;
import com.jsp.springbootcrudresponsemorning.dto.ResponseStructure;
import com.jsp.springbootcrudresponsemorning.service.LaptopService;

@RestController
public class LaptopController {

	@Autowired
	LaptopService laptopService;
	
	// insert method---------------------------------------------------------------
	@PostMapping("insertLaptop")
	public ResponseStructure<Laptop> insertLaptop(@RequestBody Laptop laptop) {
		return laptopService.insertLaptop(laptop);
	}
	
	
	// insertAll method-------------------------------------------------------------
	@PostMapping("/insertAllLaptop")
	public ResponseStructure<List<Laptop>> insertAlllaptop(@RequestBody List<Laptop> laptops){
		return laptopService.insertAllLaptop(laptops);
	}
	
	
	// getMobileById method--------------------------------------------------------
	@GetMapping("getByIdLaptop/{laptopId}")
	public ResponseStructure<Laptop> getByIdLaptop(@PathVariable int laptopId)  {
		return laptopService.getByIdLaptop(laptopId);
	}
	
	// delete method
//	@DeleteMapping("/deleteLaptop/{laptopId}")
//	public String deleteLaptop(@PathVariable int laptopId) {
//		return laptopService.deleteLaptop(laptopId);
//	}
	
	
	@DeleteMapping("/deleteLaptop/{laptopId}")
	public ResponseStructure<Laptop> deleteLaptop(@PathVariable int laptopId, Laptop laptop) {
		return laptopService.deleteLaptop(laptopId, laptop);
	}
	
	// update Method---------------------------------------------------------------
	@PutMapping("/updateLaptop/{laptopId}")
	public ResponseStructure<Laptop> updateLaptop(@RequestBody Laptop laptop, @PathVariable int laptopId){
		return laptopService.updateLaptop(laptop, laptopId);
	}
	
	// displayAll Method
	@GetMapping("/displayAllLaptop")
	public ResponseStructure<List<Laptop>> displayLaptop() {
		return laptopService.displayLaptop();
	}	
}
