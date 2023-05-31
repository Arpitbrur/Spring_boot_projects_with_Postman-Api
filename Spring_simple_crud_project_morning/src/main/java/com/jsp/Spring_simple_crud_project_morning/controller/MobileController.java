package com.jsp.Spring_simple_crud_project_morning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Spring_simple_crud_project_morning.dto.Mobile;
import com.jsp.Spring_simple_crud_project_morning.service.MobileService;

@RestController
public class MobileController {

	@Autowired
	MobileService mobileService;
	// insert method--------------------------------------------------------
	
	@PostMapping("/insertMobile")
	public Mobile insertMobile(@RequestBody Mobile mobile) {
		return mobileService.insertMobile(mobile);
	}
	
	
	// get by id method-----------------------------------------------------
	
	@GetMapping("/getById/{mobileId}")
	public Mobile getByIdMobile(@PathVariable int mobileId) {
		Mobile mobile= mobileService.getByIdMobile(mobileId);
		return mobile;
	}
	
	// update----------------------------------------------------------------
	
	@PutMapping("/updateMobile/{mobileId}")
	public String updateMobile(@RequestBody Mobile mobile, @PathVariable int mobileId) {
		return mobileService.updateMobile(mobile, mobileId);
				
	}
		
	
	// delete by id---------------------------------------------------------	
	
	@DeleteMapping("/deleteMobile/{mobileId}")
	public String getByIdDeleteMobile(@PathVariable int mobileId) {
		return mobileService.deleteMobile(mobileId);
				
	}
	
	
	
	// display method-------------------------------------------------------------
	
	@GetMapping("/displayAllMobile")
	public List<Mobile> displayAllMobile(){
		return mobileService.displayAllMobile();
	}
	

}
