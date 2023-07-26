package com.jsp.springbootcrudresponsemorning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.springbootcrudresponsemorning.dao.LaptopDao;
import com.jsp.springbootcrudresponsemorning.dto.Laptop;
import com.jsp.springbootcrudresponsemorning.dto.ResponseStructure;

@Service
public class LaptopService {

	@Autowired
	LaptopDao laptopDao;
	
	@Autowired
	ResponseStructure<Laptop> responseStructure;
	
	@Autowired
	ResponseStructure<List<Laptop>> responseStructure1;
	
//	@Autowired
//	ResponseStructure<List<Laptop>> responseStructure1;
	
	// insert method--------------------------------------------------------------
		public ResponseStructure<Laptop> insertLaptop(Laptop laptop) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Data inserted successfully..........");
			responseStructure.setData(laptop);
			
			laptopDao.insertLaptop(laptop);
			
			return responseStructure;
			
		}
	
	// insertAll method-----------------------------------------------------------
	public ResponseStructure<List<Laptop>> insertAllLaptop(List<Laptop> laptops) {
		responseStructure1.setStatusCode(HttpStatus.CREATED.value());
		responseStructure1.setMsg("Multiple data inserted............");
		responseStructure1.setData(laptops);
		
		laptopDao.insertAllLaptop(laptops);
		return responseStructure1;
	}
		
		
	// getMobileById method--------------------------------------------------------
	public ResponseStructure<Laptop> getByIdLaptop(int laptopId)  {
		Laptop laptop = laptopDao.getByIdLaptop(laptopId);
		if(laptop != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Given id is present");
			responseStructure.setData(laptop);
			return responseStructure;

		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("Given id is not present in databse");
			responseStructure.setData(laptop);
			return responseStructure;

		}
	}
	
	// delete method-----------------------------------------------------------------
//		public String deleteLaptop(int laptopId) {
//			return laptopDao.deleteLaptop(laptopId);
//		}
	
	
	public ResponseStructure<Laptop> deleteLaptop(int laptopId, Laptop laptop) {
		Laptop laptop1 = laptopDao.deleteLaptop(laptopId, laptop);
		if(laptop1 !=null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Given id is deleted");
			responseStructure.setData(laptop);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("Given id is not present in databse");
			responseStructure.setData(laptop);
			return responseStructure;
		}
	}
	
	
	// UpdateMobile------------------------------------------------------------------
	public ResponseStructure<Laptop> updateLaptop(Laptop laptop, int laptopId) {
		Laptop laptop2 = laptopDao.updateLaptop(laptop, laptopId);
		
		if(laptop2 != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Data updated Successfully");
			responseStructure.setData(laptop2);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Data not found");
			responseStructure.setData(null);
			return responseStructure;
		}
	}
	
	
	// display method-------------------------------------------------------------------
	public ResponseStructure<List<Laptop>> displayLaptop() {
		List<Laptop> list = laptopDao.displayLaptop();
		
		if(list != null) {
			responseStructure1.setStatusCode(HttpStatus.FOUND.value());
			responseStructure1.setMsg("Data-present");
			responseStructure1.setData(list);
			return responseStructure1;
			
		}else {
			responseStructure1.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure1.setMsg("Data-Not-present");
			responseStructure1.setData(null);
			return responseStructure1;
		}
	}
	
	
	
	
	
	
	
	
	
		
}
