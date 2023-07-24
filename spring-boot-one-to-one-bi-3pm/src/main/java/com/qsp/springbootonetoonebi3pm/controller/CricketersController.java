package com.qsp.springbootonetoonebi3pm.controller;

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
	public Cricketers insertCricketers(@RequestBody Cricketers cricketers) {
		return cricketrsService.insertCricketers(cricketers);
	}
		
	//getCricketerRecord-------------------------------------------------------------------
	@GetMapping("/getRecordId/{cricketersId}")
	public Record getRecordById(@PathVariable int cricketersId) {
		return cricketrsService.getRecordById(cricketersId);
	}
	
	//getCricketerById-------------------------------------------------------------------------
	@GetMapping("/getCricketersId/{cricketersId}")
	public Cricketers getCricketersById(@PathVariable int cricketersId) {
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
	public List<Cricketers> displayAllCricketers(){
		return cricketrsService.displayAllCricketers();
	}
}
