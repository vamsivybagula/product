package com.cts.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.product.entity.Product;
import com.cts.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository pr;
	
	public Product create(Product product) {
		return pr.save(product);
		
	}
public List<Product> read() {
	
	return pr.findAll();	
	}
	
public Product readById(Integer id) {
	Optional<Product> temp = pr.findById(id);
	Product p=null;
	if(temp.isPresent())
	{
		p=temp.get();
	}
	return p;
	
}

public Product delete(Integer id)
{
	Product p=readById(id);
	if(p!=null)
	{
		pr.delete(p);
	}
	return p;
}

	
	

}
