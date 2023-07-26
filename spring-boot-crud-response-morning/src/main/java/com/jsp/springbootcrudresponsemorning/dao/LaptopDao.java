package com.jsp.springbootcrudresponsemorning.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springbootcrudresponsemorning.dto.Laptop;
import com.jsp.springbootcrudresponsemorning.repository.LaptopRepository;

@Repository
public class LaptopDao {

	@Autowired
	LaptopRepository laptopRepository;
	
	// insert method--------------------------------------------------------------
	public Laptop insertLaptop(Laptop laptop) {
		return laptopRepository.save(laptop);
	}
	
	// insertAll method-----------------------------------------------------------
	public List<Laptop> insertAllLaptop(List<Laptop> laptops) {
		return laptopRepository.saveAll(laptops);
	}
	
	// getByID---------------------------------------------------------------------
	public Laptop getByIdLaptop(int laptopId) {
		Optional<Laptop> optional = laptopRepository.findById(laptopId);		
		if(optional.isPresent()) {
			return optional.get();
			
		}else {
			return null;
		}
	}
	
	// delete method
//	public String deleteLaptop(int laptopId) {
//		Optional<Laptop> optional = laptopRepository.findById(laptopId);
//		
//		if(optional.isPresent()) {
//			laptopRepository.delete(optional.get());
//			return "data deleted successfully";
//		}else {
//			return "Given id is not present in database";
//		}
//	}
	
	
	public Laptop deleteLaptop(int laptopId, Laptop laptop) {
		Optional<Laptop> optional = laptopRepository.findById(laptopId);
		
		if(optional.isPresent()) {
			laptopRepository.delete(optional.get());
			return laptop;
		}else {
			return null;
		}
	}
	// update method---------------------------------------------------------------
	public Laptop updateLaptop(Laptop laptop, int laptopId) {
		Optional<Laptop> optional = laptopRepository.findById(laptopId);
		if(optional.isPresent()) {
			laptopRepository.save(laptop);
			return laptop;
		}else {
			return null;
		}
	}
	
	// display method
	public List<Laptop> displayLaptop() {
		return laptopRepository.findAll();
	}
	
}
