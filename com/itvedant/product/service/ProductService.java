package com.itvedant.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.product.dao.AddProductDAO;
import com.itvedant.product.dao.UpdateProductFDAO;
import com.itvedant.product.entity.Product;
import com.itvedant.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productrepository;
	
	public Product createProduct(AddProductDAO addProductDAO)
	{
		Product product=new Product();
		
		product.setName(addProductDAO.getName());
		product.setPrice(addProductDAO.getPrice());
		product.setQuantity(addProductDAO.getQuantity());
		
		this.productrepository.save(product);
		
		return product;
	}
	
	
	public List<Product> readAllProducts()
	{
		
		List<Product> products=new ArrayList<Product>();
		
		products=this.productrepository.findAll();
		
		return products;
	}
	
	
	
	public Product findProductById(Integer id)
	{
		Product product=new Product();
		
		product=this.productrepository.findById(id).orElse(null);
		
		return product;
	}
	
	
	public Product updateProduct(Integer id,UpdateProductFDAO updateProductFDAO)
	{
		Product product=new Product();
		
		product=this.findProductById(id);
		
		if(updateProductFDAO.getName() !=null)
		{
			product.setName(updateProductFDAO.getName());
		}
		if(updateProductFDAO.getPrice() !=null)
		{
			product.setPrice(updateProductFDAO.getPrice());
		}
		if(updateProductFDAO.getQuantity() !=null)
		{
			product.setQuantity(updateProductFDAO.getQuantity());
		}
		
		this.productrepository.save(product);
		
		return product;
	}
	
	public String deleteProduct(Integer id)
	{
		
		Product product=new Product();
		
		product=this.findProductById(id);
		
		this.productrepository.delete(product);
		
		return "Record Deleted";
	}

}
