package com.example.springboot.springbootexample.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.springbootexample.model.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByFirstName(String firstname);
}
