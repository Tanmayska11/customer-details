package com.spring.project1.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring.project1.payloads.CustomerDto;
import com.spring.project1.services.CustomerService;



@Controller
@RequestMapping("/api/customers")

public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	

	//get all customers
	@GetMapping("/")
	public String getAllCustomers(Model model){
		
		List<CustomerDto> customers = customerService.getAllCustomers();		
		
		model.addAttribute("customers",customers);
			
		return "index";
	}
	
	
	//post-create Customer
		@PostMapping("/addCustomer")
		public String createCustomer(@Validated @ModelAttribute("customerDto") CustomerDto customerDto){
			CustomerDto createCustomerDto =this.customerService.createCustomer(customerDto);
		
			return "redirect:/api/customers/";
		}
		
		
		@GetMapping("/addCustomer")
		public String showAddCustomerForm(Model model) {
		    model.addAttribute("customerDto", new CustomerDto());
		    return "addCustomer";
		}
		
				
		@PostMapping("/update")
		public String updateCustomer( @Validated @ModelAttribute("customerDto") CustomerDto customerDto){
			CustomerDto updatedCustomer =this.customerService.updateCustomer(customerDto);
			//return new ResponseEntity<>(updatedCustomer,HttpStatus.OK);
			return "redirect:/api/customers/";
			
		}
		

	
	//delete -delete Customer
		@PostMapping("/delete")
		public String deleteCustomer( @RequestParam("customerId") String customerId){
			
			this.customerService.deleteCustomer(customerId);
			
			//return new ResponseEntity<ApiResponse>(new ApiResponse("message Customer deleted sucessfully",true),HttpStatus.OK);
			return "redirect:/api/customers/"; 
		}
	
	
		
		@GetMapping("/update/{customerId}")
		public String showUpdateCustomerForm(@PathVariable String customerId,Model model){
			CustomerDto customerDto=this.customerService.getCustomerById(customerId);
			model.addAttribute("customerDto", customerDto);
			return "updateCustomer"; 
		}

}
