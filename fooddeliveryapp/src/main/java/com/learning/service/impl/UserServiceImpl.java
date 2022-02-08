package com.learning.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dto.Login;
import com.learning.dto.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.UserRepository;
import com.learning.service.LoginService;
import com.learning.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LoginService loginService;
	
	@Override
	public Register addUser(Register register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if (userRepository.existsByEmail(register.getEmail())==true) {
			throw new AlreadyExistsException("Already existing record");
		}
		
		Register register2 = userRepository.save(register);
		System.out.println(register2);
		System.out.println("test");
		if (register2!=null) {
			System.out.println("Success");
			Login login = new Login(register.getEmail(), register.getPassword(), register2);
			String res = loginService.addCredentials(login);
			if(res!="success") {
			return null;
			}
			else {
				return register2;
			}
		}
		else {
				return null;
		}
	}

	@Override
	public Register updateUser(int id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(!this.userRepository.existsById(id))
			throw new IdNotFoundException("Sorry user with ID:" + register.getId() + " not found");
		
		return userRepository.save(register);
	}

	@Override
	public Register getUserById(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Id not found");
		}
		else {
			return optional.get();
		}
	}

	@Override
	public String deleteUserById(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Register> optional = Optional.ofNullable(this.getUserById(id));
			if(optional.isEmpty()) {
				throw new IdNotFoundException("User not found");
			}
			else {
				userRepository.deleteById(id);
				loginService.deleteCredentials(optional.get().getEmail());
				System.out.println("deleted");
				return "successfully deleted user";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Register>> getAllUserDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}

}
