package com.zee.zee5app.service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;

public class UserService {

	private UserRepository repository = UserRepository.getInstance();
	
	private UserService() {
		
	}
	private static UserService service= null;
	
	public static UserService getInstance() {
		if (service==null)
		service = new UserService();
		return service;
	}
	
	public String addUser(Register register) {
		return this.repository.addUser(register);
		
	}
	public Register getUserByID(String id) {
		return repository.getUserByID(id);
	}
	public Register[] getAllUsers() {
		return repository.getUsers();
	}
	public String updateUser(String id, Register register) {
		return repository.updateUser(id, register);
	}
}
