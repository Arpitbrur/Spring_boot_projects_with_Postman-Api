package com.jsp.Spring_simple_crud_project_morning.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Spring_simple_crud_project_morning.dto.Mobile;
import com.jsp.Spring_simple_crud_project_morning.repository.MobileRepository;

@Repository   // because this class is belongs to database
public class MobileDao {

	@Autowired     // it is used to create a object reference for a particurler class.
	MobileRepository mobileRepository;
	
	// insert method---------------------------------------------------
	
	public Mobile insertMobile(Mobile mobile) {
	return	mobileRepository.save(mobile);
	}
	
	
	// get by id method-----------------------------------------------------
	
	public Mobile getByIdMobile(int mobileId) {
		Optional<Mobile> optional = mobileRepository.findById(mobileId);
		
		if(optional.isPresent()) {
			 Mobile mobile=optional.get();
			 return mobile;
		}else {
			return null;
		}
	}
	
	// update method-------------------------------------------------------------
	
	public void updateMobile(Mobile mobile ,int mobileId) {
		Optional<Mobile> optional = mobileRepository.findById(mobileId);
		
		Mobile mobile1 =optional.get();
		
		if(mobile.getMobileName() != null && mobile.getMobileColor() != null ) {
			mobile1.setMobileName(mobile.getMobileName());
			mobile1.setMobileColor(mobile.getMobileColor());
			mobile1.setMobilePrice(mobile.getMobilePrice());
			
			mobileRepository.save(mobile1);
			
		}else if(mobile.getMobileName()!= null) {
			mobile1.setMobileName(mobile.getMobileName());
			mobileRepository.save(mobile1);
		}else {
			mobile1.setMobileColor(mobile.getMobileColor());
			mobileRepository.save(mobile1);
		}
		
	}
	
	// delete by id---------------------------------------------------------
	
//	public void deleteMobile(int mobileId) {
//		Optional< Mobile> optional = mobileRepository.findById(mobileId);
//		
//		if(optional.isPresent()) {
//			Mobile mobile = optional.get();
//			mobileRepository.delete(mobile);
//		}
//	}	
//	
	public int deleteMobile(int mobileId) {
		Optional<Mobile> optional = mobileRepository.findById(mobileId);
		
		if(optional.isPresent()) {
			Mobile mobile = optional.get();
			int mobileId1 = optional.get().getMobileId();
			mobileRepository.delete(mobile);

			return mobileId1;			
		}
		return 0;
	}
	
	
	// display method-------------------------------------------------------------
	
	public List<Mobile> displayAllMobile(){
		return mobileRepository.findAll();
	}
		
}
