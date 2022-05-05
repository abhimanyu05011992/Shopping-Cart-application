package com.example.springboot.springbootexample.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.springboot.springbootexample.model.Product;

import com.example.springboot.springbootexample.repo.ProductRepository;

@RestController
@RequestMapping("/itemapi")
public class ProductRestController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value="/products",method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product)
	{
		return productRepository.save(product);
	}
	
	@RequestMapping(value="/products",method = RequestMethod.GET)
	public Product[] getProducts()
	{
		
		 List<Product> productList=productRepository.findAll();
		 Product[] products= new Product[productList.size()];
		 return productList.toArray(products);
	}
	
	@RequestMapping(value="/product/{id}",method = RequestMethod.GET)
	public Product getCoupon(@PathVariable("id") Integer id)
	{
		return productRepository.getById(id);
	}
	
	@RequestMapping(value="/products/{count}",method = RequestMethod.GET)
	public List<Product> createCoupon(@PathVariable("count") Integer count)
	{
		return productRepository.findAll().stream().limit(count).collect(Collectors.toList());
	}

}
