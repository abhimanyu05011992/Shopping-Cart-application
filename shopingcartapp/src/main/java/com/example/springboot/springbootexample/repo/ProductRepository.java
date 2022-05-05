package com.example.springboot.springbootexample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.springbootexample.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
