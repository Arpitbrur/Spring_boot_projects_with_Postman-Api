package com.jsp.simplespringproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.simplespringproject.dto.Product;
import com.jsp.simplespringproject.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//insert Product------------------------------------------------------------------------
	@PostMapping("/insertProduct")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}	
	
	//insert All Product------------------------------------------------------------------------
	@PostMapping("/insertAllProduct")
	public List<Product> saveAllProduct(@RequestBody List<Product> product) {
		return productService.saveAllProduct(product);
	}	
	// getById------------------------------------------------------------------------------
	@GetMapping("/getById/{productId}")
	public Product getById(@PathVariable int productId) {
		return productService.getById(productId);
	}	
	
	// delete product-------------------------------------------------------------------------
	@DeleteMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		return productService.deleteProduct(productId);
	}	
	
	// update product----------------------------------------------------------------------------
	@PutMapping("/updateProduct/{productId}")
	public Product updateProduct(@PathVariable int productId, @RequestBody Product product) {
		return productService.updateProduct(productId, product);
	}	
	
	// displayAllProduct-------------------------------------------------------------------------
	@GetMapping("/displayAllProduct")
	public List<Product> displayAllProduct(){
		return productService.displayAllProduct();
	}	
}
