package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.userRepo;
import com.zee.zee5app.repository.impl.userRepoImpl;
import com.zee.zee5app.service.UserService;

public class UserServiceImpl implements UserService {

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserService service;
	
	public static UserService getInstance() {
		if (service==null) {
			service= new UserServiceImpl();
		}
		return service;
	}
	
	userRepo repository = userRepoImpl.getInstance();

	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return this.repository.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return repository.getUserById(id);
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return repository.getAllUsers();
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return repository.deleteUserById(id);
		//return null;
	}

	@Override
	public List<Register> getAllUserDetails() {
		// TODO Auto-generated method stub
		return repository.getAllUserDetails();
	}

}
