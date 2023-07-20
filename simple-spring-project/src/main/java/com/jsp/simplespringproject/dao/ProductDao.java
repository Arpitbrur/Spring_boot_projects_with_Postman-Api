package com.jsp.simplespringproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.simplespringproject.dto.Product;
import com.jsp.simplespringproject.repository.ProductRepository;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepository productRepository;
	
	//insert Product------------------------------------------------------------------------
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	//insert All Product------------------------------------------------------------------------
	public List<Product> saveAllProduct(List<Product> product) {
		return productRepository.saveAll(product);
	}
	
	// getById------------------------------------------------------------------------------
	public Product getById(int productId) {
		Optional<Product> optional = productRepository.findById(productId);
		
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	// delete product-------------------------------------------------------------------------
	public String deleteProduct(int productId) {
		Optional<Product> optional = productRepository.findById(productId);
		
		if(optional.isPresent()) {
			Product product = optional.get();
			productRepository.delete(product);
			return "Data deleted successfully";
		}else {
			return "Given id is not present in db";
		}
	}
	
	// update product----------------------------------------------------------------------------
	public Product updateProduct(int productId, Product product) {
		Optional<Product> optional = productRepository.findById(productId);
		
		Product product1 = optional.get();

		if(product.getProductName() != null && product.getProductColor()!= null && product.getProductPrice()!= null) {
			product1.setProductName(product.getProductName());
			product1.setProductColor(product.getProductColor());
			product1.setProductPrice(product.getProductPrice());
			
			 return productRepository.save(product1);
		}else if(product.getProductColor()!= null && product.getProductPrice()!= null) {
			product1.setProductColor(product.getProductColor());
			product1.setProductPrice(product.getProductPrice());
			
			return productRepository.save(product1);
		}else {
			product1.setProductPrice(product.getProductPrice());
			productRepository.save(product1);

		}
		return product1;
		
	}
	
	// displayAllProduct---------------------------------------------------------------
	public List<Product> displayAllProduct(){
		return productRepository.findAll();
	}
	
}
