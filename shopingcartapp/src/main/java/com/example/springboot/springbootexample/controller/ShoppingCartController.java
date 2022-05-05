package com.example.springboot.springbootexample.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springboot.springbootexample.model.Product;
import com.example.springboot.springbootexample.repo.ProductRepository;
import com.example.springboot.springbootexample.repo.ShoppingCartRepository;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RestTemplate resttemp;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/allproducts",method=RequestMethod.GET)
	public List<Product> getAllproductdetails()
	{
		Product[] products=resttemp.getForObject("http://localhost:9098/itemapi/products",Product[].class);
		return Arrays.asList(products);
	}
	
	@RequestMapping(value="/someproducts/{noofproduct}",method=RequestMethod.GET)
	public List<Product> getnoofproductdetails(@PathVariable("noofproduct") Integer noofproduct)
	{
		Product[] products=resttemp.getForObject("http://localhost:9098/itemapi/products/"+noofproduct,Product[].class);
		return Arrays.asList(products);
	}
	
	
	
	
}
