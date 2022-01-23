package com.zee.zee5app.dto;

import javax.naming.InvalidNameException;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data

public class Register  implements  Comparable<Register>
{
	
	
	
	@Setter(value = AccessLevel.NONE)
	private String id;
	//write a code to validate the length and assign the value
	@Setter(value = AccessLevel.NONE)
	private String firstName;
	
	@Setter(value = AccessLevel.NONE)
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

	public void setId(String id) throws InvalidIdLengthException {
		//throws: provides the list of exceptions that may be raised
		//it will hold the list of checked exceptions
		
		if (id.length()<2 || id.length()>4) {
			//it should raise invalid ID length exception
			throw new InvalidIdLengthException("id length invalid");
		}
		this.id = id;
	}
	
	public void setFirstName(String firstName) throws InvalidNameException {
		
		if (firstName==null || firstName.length()<2 || firstName== "") {
			throw new InvalidNameException("First Name is invalid");
		}
		this.firstName = firstName;
	}
	public void setLastName(String lastName) throws InvalidNameException {
		
		if(lastName==null || lastName.length()<2 || lastName=="") {
			throw new InvalidNameException("Last name invalid");
		}
		this.lastName = lastName;
	}

	
	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		//this.getId() -> Descending, o.getId() ->Ascending
		
		return o.id.compareTo(this.getId());
	}
	
}
