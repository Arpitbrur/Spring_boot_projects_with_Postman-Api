package com.jsp.Spring_simple_crud_project_morning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsp.Spring_simple_crud_project_morning.dao.MobileDao;
import com.jsp.Spring_simple_crud_project_morning.dto.Mobile;

@Service
public class MobileService {

	@Autowired          // it is used to create a object reference for a particurler class.
	MobileDao dao;

	// insert method-------------------------------------------------------------
	
	public Mobile insertMobile(Mobile mobile) {
		 return dao.insertMobile(mobile);
	}
	
	
	// get by id method----------------------------------------------------------
	
	public Mobile getByIdMobile(int mobileId) {
		return dao.getByIdMobile(mobileId);
	}
		
	
	// update--------------------------------------------------------------------
	
	public String updateMobile(Mobile mobile ,int mobileId) {
		if(dao.getByIdMobile(mobileId) != null) {
			dao.updateMobile(mobile, mobileId);
			return ("Data is updated Successfully.................");
		}else {
			return ("Given id is not present................");

		}
		
	}
	
	// delete by id--------------------------------------------------------------
	
	public String deleteMobile(int mobileId) {
		if(dao.getByIdMobile(mobileId) != null) {
			dao.deleteMobile(mobileId);
			return ("data deleted successfully...................");
		}else {
			return ("given id is not present.................");
		}
	}	

	
	// display method-------------------------------------------------------------
	
	public List<Mobile> displayAllMobile(){
		return dao.displayAllMobile();
	}
		
}
