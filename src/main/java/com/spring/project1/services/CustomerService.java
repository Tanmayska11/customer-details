package com.spring.project1.services;


import java.util.List;

import com.spring.project1.payloads.CustomerDto;

public interface CustomerService {
	
	public CustomerDto createCustomer(CustomerDto customer);
	
	public CustomerDto updateCustomer(CustomerDto customer);
	
	public CustomerDto getCustomerById(String customerId);
	
	public List<CustomerDto> getAllCustomers();
	
	public void deleteCustomer(String customerId);

}
