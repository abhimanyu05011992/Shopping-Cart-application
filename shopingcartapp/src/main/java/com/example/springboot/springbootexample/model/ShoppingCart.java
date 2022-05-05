package com.example.springboot.springbootexample.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="shoppingcart")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
private String name;

/*
@OneToMany
private Set<Product> products;
*/

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



@Override
public String toString() {
	return "ShoppingCart [id=" + id + ", name=" + name + "]";
}

}
