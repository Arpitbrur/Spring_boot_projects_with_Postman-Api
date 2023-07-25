package com.qsp.springbootonetoonebi3pm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.springbootonetoonebi3pm.dao.RecordDao;

@Service
public class RecordService {

	@Autowired
	private RecordDao recordDao;
	
	// insert record-----------------------------------------------------------------------
//	public Record insertRecord(Record record) {
//		return recordDao.insertRecord(record);
//	}	
}
