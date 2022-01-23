package com.zee.zee5app.repository;

//import java.util.Iterator;

import com.zee.zee5app.dto.Register;
//import com.zee.zee5app.service.UserService;

public class UserRepository {

	private Register[] registers = new Register[10];
	private static int count=0;
	private UserRepository() {
		
	}
	
	//return user details from id
	public Register getUserByID(String id) {
		for (Register register: registers) {
			if (register!=null && register.getId().equals(id)){
				return register;
			}
		}
		return null;
	}
	
	//return all user details
	public Register[] getUsers() {
		return registers;
	}
	
	//update user details
	public String updateUser(String id, Register register) {
		for (int c=0;c<registers.length;c++) {
			if (registers[c]!=null && registers[c].getId().equals(id)) {
				registers[c]=register;
				return "User details updated";
			}
		}
		return "Invalid id";
	}
	
	
	//delete user credentials
	/*
	public String deleteUser(String id) {
		
	}
	*/
	
	
	//add a new user
	public String addUser(Register register) {
		//registers.length : give us the availability of the array
		if (count==registers.length) {
			//array is full or go for dynamic array allocation
			Register temp[] = new Register[registers.length * 2];
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers=temp;
			
			registers[count++]= register;
			return "User Added";
			//return "array is full";
		}
		registers[count++]= register;
		return "User Added";
	}
	
	private static UserRepository userRepository;
	public static UserRepository getInstance() {
		if (userRepository==null)
			userRepository = new UserRepository();
		return userRepository;
	}
	
	
}
