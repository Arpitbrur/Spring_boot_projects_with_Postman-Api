package com.qsp.springbootonetoonebi3pm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.springbootonetoonebi3pm.dao.CricketersDao;
import com.qsp.springbootonetoonebi3pm.dto.Cricketers;
import com.qsp.springbootonetoonebi3pm.dto.Record;

@Service
public class CricketrsService {

	@Autowired
	CricketersDao cricketersDao;
	
	//insert method------------------------------------------------------------------------
	public Cricketers insertCricketers(Cricketers cricketers) {
		return cricketersDao.insertCricketers(cricketers);
	}
		
	//getCricketerRecord-------------------------------------------------------------------
	public List<Object> getCricketersById(int cricketersId){
		return cricketersDao.getCricketersById(cricketersId);
	}
	
	// delete Cricketer---------------------------------------------------------------------------
	public String deleteCricketer(int cricketersId) {
		if(cricketersDao.getCricketersById(cricketersId)!= null) {
			cricketersDao.deleteCricketer(cricketersId);
			return "data deleted successfully...................";
		}else {
			return "given id is not present.................";
		}
	}	
	
	// update cricketer-------------------------------------------------------------------------------
	public Cricketers updateCricketers(Cricketers cricketers, int cricketersId) {
		return cricketersDao.updateCricketers(cricketers, cricketersId);
	}
	
	// getAllCricketers--------------------------------------------------------------------
	public List<Cricketers> displayAllCricketers(){
		return cricketersDao.displayAllCricketers();
	}	
		
}
