package com.qsp.springbootonetoonebi3pm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springbootonetoonebi3pm.repository.RecordRepository;

@Repository
public class RecordDao {

	@Autowired
	private RecordRepository recordRepository;
	
	// insert record-----------------------------------------------------------------------
//	public Record insertRecord(Record record) {
//		return recordRepository.save(record);
//	}
}
