package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;

public interface UserService {
	public String addUser(Register register);
	public String updateUser(String id, Register register);
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidNameException, InvalidIdLengthException, com.zee.zee5app.exception.InvalidNameException;
	public Register[] getAllUsers();
	public String deleteUserById(String id) throws IdNotFoundException;
	public List<Register> getAllUserDetails();
}
