package com.spring.project1.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project1.entities.Customer;
import com.spring.project1.exceptions.ResourceNotFoundException;
import com.spring.project1.payloads.CustomerDto;
import com.spring.project1.repositories.CustomerRepo;
import com.spring.project1.services.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		// creation of Customer
		Customer customer =this.dtoToCustomer(customerDto);
		Customer savedCustomer = this.customerRepo.save(customer);
		return this.customerToDto(savedCustomer);
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) {
		//update the Customer by id
		Customer customer =this.customerRepo.findById(customerDto.getId())
				.orElseThrow((() -> new ResourceNotFoundException("Customer" , "Id" ,customerDto.getId())));
		
		
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setStreet(customerDto.getStreet());
		customer.setAddress(customerDto.getAddress());
		customer.setCity(customerDto.getCity());
		customer.setState(customerDto.getState());
		
		
		customer.setEmail(customerDto.getEmail());
		customer.setPhone(customerDto.getPhone());
	//	customer.setPassword(customerDto.getPassword());
		
		Customer updatedCustomer=this.customerRepo.save(customer);
		CustomerDto customerDto1= this.customerToDto(updatedCustomer);
		
		return customerDto1;
	}

	@Override
	public CustomerDto getCustomerById(String customerId) {
		Customer customer =this.customerRepo.findById(customerId)
				.orElseThrow((() -> new ResourceNotFoundException("Customer" , "Id" ,customerId)));
		
		return this.customerToDto(customer);
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
	
		List<Customer> customers = this.customerRepo.findAll();
		
		List<CustomerDto>customerDtos=customers.stream().map(customer ->this.customerToDto(customer)).collect(Collectors.toList());
		return customerDtos;
	}

	@Override
	public void deleteCustomer(String customerId) {
		Customer customer =this.customerRepo.findById(customerId)
				.orElseThrow((() -> new ResourceNotFoundException("Customer" , "Id" ,customerId)));
		
			this.customerRepo.deleteById(customerId);

	}
	
	public Customer dtoToCustomer(CustomerDto customerDto) {
		
		Customer customer= modelMapper.map(customerDto, Customer.class);
		
		
//		Customer Customer=new Customer();
//		Customer.setId(CustomerDto.getId());;
//		Customer.setName(CustomerDto.getName());
//		Customer.setEmail(CustomerDto.getEmail());
//		Customer.setAbout(CustomerDto.getAbout());
//		Customer.setPassword(CustomerDto.getPassword());
		return customer;
		
	}

	public CustomerDto customerToDto(Customer customer) {
		
		CustomerDto customerDto=modelMapper.map(customer, CustomerDto.class);
		
//		CustomerDto CustomerDto=new CustomerDto();
//		CustomerDto.setId(Customer.getId());;
//		CustomerDto.setName(Customer.getName());
//		CustomerDto.setEmail(Customer.getEmail());
//		CustomerDto.setAbout(Customer.getAbout());
//		CustomerDto.setPassword(Customer.getPassword());
		return customerDto;
		
	} 

}
