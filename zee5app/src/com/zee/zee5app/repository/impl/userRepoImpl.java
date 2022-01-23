package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
//import java.util.set;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
//import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.userRepo;

public class userRepoImpl implements userRepo {
	
	private TreeSet<Register> set = new TreeSet();
	
	
	//private Register[] registers = new Register[10];
	//private static int count=0;
	
	private userRepoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static userRepo repository;
	
	public static userRepo getInstance() {
		if (repository==null) {
			repository = new userRepoImpl();
		}
		return repository;
	}

	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		boolean result= this.set.add(register);
		if (result==true) {
			return "Successfully added user";
		}
		return "Failed to add user";
	}

	@Override
	//assignment
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Register register2 = null;
		for (Register register : set) {
			if(register.getId().equals(id)) {
				register2 = register;
				break;
				//return Optional.of(register);			
			}
		}
		return Optional.of(Optional.ofNullable(register2).orElseThrow(() -> new IdNotFoundException("ID not found")));
		//if register2 is null, it acts like empty()
		//if register2 is holding object it acts like of()
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		//transform the collection to array
		
		Register register[]= new Register[set.size()];
		
		return set.toArray(register);
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = this.getUserById(id);
		if(optional.isPresent()) {
			//removal
			boolean result = set.remove(optional.get());
			if (result) {
				return "Successfully deleted user";
				
			}
			else {
				return "Failed to delete user";
			}
		}
		/*
		 * else { //throw IdNotFoundException throw new
		 * IdNotFoundException("id not found for deletion");
		 * 
		 * }
		 */
		
		return "fail";
	}
	
	@Override
	public List<Register> getAllUserDetails() {
		// TODO Auto-generated method stub
		//return in sorted manner
		//Collections.sort((List<Register>) set);
		
		//return set;
		
		set.descendingSet();
		return new ArrayList<>(set.descendingSet());
	}
	
}
