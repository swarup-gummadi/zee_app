package com.learning.service;

import java.util.List;
import java.util.Optional;

import com.learning.dto.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;

public interface UserService {

	public Register addUser(Register register) throws AlreadyExistsException;
	public Register updateUser(int id, Register register) throws IdNotFoundException;
	public Register getUserById(int id) throws IdNotFoundException;
	public String deleteUserById(int id) throws IdNotFoundException;
	public Optional<List<Register>> getAllUserDetails();
}
