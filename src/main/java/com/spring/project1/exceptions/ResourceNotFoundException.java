package com.spring.project1.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{

	String resourceName;
	String fieldName;
	String fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, String customerId) {
		super(String.format("%s not found with %s : %s", resourceName ,fieldName ,customerId));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = customerId;
	}
	
}
