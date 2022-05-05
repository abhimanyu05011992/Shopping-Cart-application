package com.example.springboot.springbootexample.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.springbootexample.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
