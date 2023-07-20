package com.jsp.simplespringproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.simplespringproject.dao.ProductDao;
import com.jsp.simplespringproject.dto.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	//insert Product------------------------------------------------------------------------
	public Product saveProduct(Product product) {
		return dao.saveProduct(product);
	}	
	
	//insert All Product------------------------------------------------------------------------
	public List<Product> saveAllProduct(List<Product> product) {
		return dao.saveAllProduct(product);
	}	
	
	// getById------------------------------------------------------------------------------
	public Product getById(int productId) {
		return dao.getById(productId);
	}
	
	// delete product-------------------------------------------------------------------------
	public String deleteProduct(int productId) {
		return dao.deleteProduct(productId);
	}	
	
	// update product----------------------------------------------------------------------------
	public Product updateProduct(int productId, Product product) {
		return dao.updateProduct(productId, product);
	}	
	
	// displayAllProduct---------------------------------------------------------------
	public List<Product> displayAllProduct(){
		return dao.displayAllProduct();
	}	
	
}
