package com.zee.zee5app.dto;

import lombok.Data;

@Data

public class Register {

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	//private: accessible only inside the class
	
	//setter: used to set the value for a particular field
	//getter: used to get/return the value for a specific field
	
	public Register() {
		//Explicit Default Constructor(EDC)
		//Any kind of customization during the initialization of object: use EDC or PC or both
		//System.out.println("hello");
	}
}
