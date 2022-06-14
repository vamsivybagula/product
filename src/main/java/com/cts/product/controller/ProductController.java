package com.cts.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.entity.Product;
import com.cts.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	@PostMapping
	public String addProduct(@RequestBody Product product)
	{
		ps.create(product);
		return "Product added";
		
	}
	@GetMapping("/")
	public List<Product> retrieveAllProducts()
	{
		return ps.read();
	}
	@GetMapping("/{id}")
	public Product retrieveById(@PathVariable("id") Integer id)
	{
		return ps.readById(id);
	}
	@DeleteMapping("/{id}")
	public Product deleteProduct(@PathVariable("id") Integer id)
	{
		return ps.delete(id);
	}
	@GetMapping("/hai")
	public String hai()
	{
		return "heyyyy";
	}
	

}
