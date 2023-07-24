package com.qsp.springbootonetoonebi3pm.dao;

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
	
	//getCricketerRecord-------------------------------------------------------------------
	public Record getRecordById(int cricketersId) {
		Optional<Cricketers> optional = cricketersRepository.findById(cricketersId);
		if(optional.isPresent()) {
			return optional.get().getRecord();
		}else {
			return null;
		}
	}
	
	
	//getCricketerById-------------------------------------------------------------------------
	public Cricketers getCricketersById(int cricketersId) {
		Optional<Cricketers> optional = cricketersRepository.findById(cricketersId);
		if(optional.isPresent()) {
			return optional.get();
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
}
