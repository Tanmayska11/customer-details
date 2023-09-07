package com.spring.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.project1.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, String>{

}
