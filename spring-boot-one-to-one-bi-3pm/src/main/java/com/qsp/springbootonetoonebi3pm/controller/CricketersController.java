package com.qsp.springbootonetoonebi3pm.controller;

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

import com.qsp.springbootonetoonebi3pm.dto.Cricketers;
import com.qsp.springbootonetoonebi3pm.dto.Record;
import com.qsp.springbootonetoonebi3pm.service.CricketrsService;

@RestController
public class CricketersController {

	@Autowired
	CricketrsService cricketrsService;
	
	//insert method------------------------------------------------------------------------
	@PostMapping("/saveCricketers")
	public List<Object> insertCricketers(@RequestBody Cricketers cricketers) {
		
		Cricketers cricketers2=cricketrsService.insertCricketers(cricketers);
		
		List<Object> objects = new ArrayList<Object>(Arrays.asList(cricketers2,cricketers2.getRecord()));
	
		return objects;
	}
		
	//getCricketerById-------------------------------------------------------------------------
	@GetMapping("/getCricketersById/{cricketersId}")
	public List<Object> getCricketersById(@PathVariable int cricketersId){
		return cricketrsService.getCricketersById(cricketersId);
	}	
			
	// delete Cricketer---------------------------------------------------------------------------
	@DeleteMapping("/deleteCricketers/{cricketersId}")
	public String deleteCricketer(@PathVariable int cricketersId) {
		return cricketrsService.deleteCricketer(cricketersId);
	}		
	
	// update cricketer-------------------------------------------------------------------------------
	@PutMapping("/updateCricketers/{cricketersId}")
	public Cricketers updateCricketers(@RequestBody Cricketers cricketers, @PathVariable int cricketersId) {
		return cricketrsService.updateCricketers(cricketers, cricketersId);
	}	
		
	// getAllCricketers--------------------------------------------------------------------
	@GetMapping("/getAllCricketers")
	public List<Object> displayAllCricketers(){
		
		List<Cricketers> cricketers = cricketrsService.displayAllCricketers();
		
		List<Object> list = new ArrayList<Object>();
		
		for (Cricketers cricketers2 : cricketers) {
			list.add(cricketers2);
			list.add(cricketers2.getRecord());
		}
		
		return list;
	}
}
