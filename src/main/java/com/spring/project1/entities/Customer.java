package com.spring.project1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "customers")
@NoArgsConstructor
@Data //its a combination of @setter @getter & @toString mth
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@Column(name="first_Name" ,nullable = false ,length =100)
	private String firstName;
	
	@Column(name="last_Name" ,nullable = false ,length =100)
	private String lastName;
	
	private String street;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String email;
	
	
	
	private String phone;
	
	
}
