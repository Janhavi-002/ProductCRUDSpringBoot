package com.itvedant.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itvedant.product.dao.AddProductDAO;
import com.itvedant.product.dao.UpdateProductFDAO;
import com.itvedant.product.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody AddProductDAO addProductDAO)
	{
		
		return ResponseEntity.ok(this.productservice.createProduct(addProductDAO));
	}
	
	@GetMapping("")
	public ResponseEntity<?> readAll()
	{
		
		return ResponseEntity.ok(this.productservice.readAllProducts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> readById(@PathVariable Integer id)
	{
		
		return ResponseEntity.ok(this.productservice.findProductById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody UpdateProductFDAO updateProductFDAO)
	{
		
		return ResponseEntity.ok(this.productservice.updateProduct(id,updateProductFDAO));
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id)
	{
		return ResponseEntity.ok(this.productservice.deleteProduct(id));
	}
	
}
