package com.qsp.springbootonetoonebi3pm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springbootonetoonebi3pm.service.RecordService;

@RestController
public class RecordController {

	@Autowired
	private RecordService recordService;
	
	// insert record-----------------------------------------------------------------------
//	@PostMapping("/saveRecord")
//	public Record insertRecord(@RequestBody Record record) {
//		return recordService.insertRecord(record);
//	}	
}
