package com.qsp.springbootonetoonebi3pm.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springbootonetoonebi3pm.dto.Cricketers;
import com.qsp.springbootonetoonebi3pm.dto.Record;
import com.qsp.springbootonetoonebi3pm.repository.CricketersRepository;

@Repository
public class CricketersDao {

	@Autowired	
	CricketersRepository cricketersRepository;
	
	//insert method------------------------------------------------------------------------
	public Cricketers insertCricketers(Cricketers cricketers) {
		return cricketersRepository.save(cricketers);
	}
	
	//getCricketerById-------------------------------------------------------------------------
	public List<Object> getCricketersById(int cricketersId){
		List<Object> cricketers = new ArrayList<Object>();
		
		Optional<Cricketers> optional = cricketersRepository.findById(cricketersId);
		if(optional.isPresent()) {
			Cricketers cricketers1 = optional.get();
			Record record = cricketers1.getRecord();
			
			cricketers.add(cricketers1);
			cricketers.add(record);
			return cricketers;
		}else {
			return null;
		}
	}
	
	// delete Cricketer---------------------------------------------------------------------------
	public int deleteCricketer(int cricketersId) {
		Optional<Cricketers> optional = cricketersRepository.findById(cricketersId);
		
		if(optional.isPresent()) {
			 Cricketers cricketers= optional.get();
			 int cricketers1 = optional.get().getCricketersId();
			 cricketersRepository.delete(cricketers);
			
			 return cricketers1;
		}else {
			return 0;
		}
	}
	
	// update cricketer-------------------------------------------------------------------------------
	public Cricketers updateCricketers(Cricketers cricketers, int cricketersId) {
		Optional<Cricketers> optional = cricketersRepository.findById(cricketersId);
		
		Cricketers cricketers2 = optional.get();
	
		if((cricketers.getCricketersName()!= null) && (cricketers.getCricketersCountry()!=null) && (cricketers.getCricketersAge()!=0) && (cricketers.getRecord()!=null)) {
			cricketers2.setCricketersName(cricketers.getCricketersName());
			cricketers2.setCricketersCountry(cricketers.getCricketersCountry());
			cricketers2.setCricketersAge(cricketers.getCricketersAge());
			
			return cricketersRepository.save(cricketers2);
		}else if((cricketers.getCricketersName()!= null) && (cricketers.getCricketersCountry()!=null)){
			cricketers2.setCricketersName(cricketers.getCricketersName());
			cricketers2.setCricketersCountry(cricketers.getCricketersCountry());


			return cricketersRepository.save(cricketers2);
		}else {
			cricketers2.setCricketersCountry(cricketers.getCricketersCountry());
			
			return cricketersRepository.save(cricketers2);
		}
	}
	
	// getAllCricketers--------------------------------------------------------------------
	public List<Cricketers> displayAllCricketers(){
		return cricketersRepository.findAll();
	}
	
//	public List<Cricketers> displayAllCricketers(){
//		List<Cricketers> list = new ArrayList<Cricketers>();
//		List<Record> list1 = new ArrayList<Record>();
//		
//		List<Cricketers> cricketers = cricketersRepository.findAll();
//		for (Cricketers cricketer : cricketers) {
//			list.add(cricketer);
//			list1.add(cricketer.getRecord());
//		
//		}
//		
//		return list;
//	}
	
}
