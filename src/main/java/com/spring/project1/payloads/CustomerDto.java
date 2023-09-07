package com.spring.project1.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
public class CustomerDto {
	
	private String id;
	
	@NotEmpty
	@Size(min =1,message= "username must bebe the 4 character")
	private String firstName;
	
	@NotEmpty(message="passward must be the min 3 or the max 10 character")
	@Size(min=1 ,max=10)
	private String lastName;
	
	private String street;
	
	private String address;
	
	private String city;
	
	private String state;
	
	@Email(message = "email id is not valid")
	private String email;
	
//	@Pattern(regexp = ) this is the pattern for regular expression match with number or character
	//private String password;
	
	@NotEmpty(message="cannot be null")
	private String phone;

}
