package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService;

public class UserServiceImpl implements UserService {

	public UserServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	private static UserService service;
	
	public static UserService getInstance() throws IOException {
		if (service==null) {
			service= new UserServiceImpl();
		}
		return service;
	}
	
	UserRepository repository = UserRepositoryImpl.getInstance();

	
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
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidNameException, InvalidIdLengthException, com.zee.zee5app.exception.InvalidNameException {
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
