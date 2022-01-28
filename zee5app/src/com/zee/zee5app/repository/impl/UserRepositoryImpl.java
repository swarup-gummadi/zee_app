package com.zee.zee5app.repository.impl;
import java.util.ArrayList;
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
import com.zee.zee5app.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
	
private UserRepositoryImpl() {
		
	}
	private static UserRepository repository;
	public static UserRepository getInstance() {
		if(repository==null) {
			repository = new UserRepositoryImpl();
		}
		return repository;
	}
	
	private TreeSet<Register> set = new TreeSet<>();

	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		boolean result = this.set.add(register);
		System.out.println(this.set.size());
		if(result) {
			
		
		return "success";}
		
	else {
		return "fail";
	}
		}

	

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Register register2 = null;
		for (Register register : set) {
			if(register!=null && register.getId().equals(id)) {
				register2 = register ;
				break;
			}
		}
		return Optional.ofNullable(Optional.of(register2).orElseThrow(()-> new IdNotFoundException("id not found")));
//		return Optional.of(Optional.ofNullable(register2).orElseThrow(()-> new IdNotFoundException("id not found")));
//		if register is holding null it will act like empty
//		if register is holding object if will act like of
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		Register[] register = new Register[set.size()];
		
		return set.toArray(register);
	}
	
	
	
	@Override
	public List<Register> getAllUserDetails(){
//		Collections.sort(set);
//		return set;
		
		return new ArrayList<>(set.descendingSet());
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = this.getUserById(id);
		if(optional.isPresent()) {
			boolean result = set.remove(optional.get());
			
			if(result) {
				return "Success";
			}
			else
				return "fail";
		}
		return "fail";
		
		
	}
	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = this.getUserById(id);
		if(optional.isPresent()) {
			boolean result = set.remove(optional.get());
			set.add(register);
			if(result) {
				return "Success";
			}
			else
				return "fail";
			
		}
		return "fail";
	}

}