package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LoginService loginService;
	
	
	public UserServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
	public Register addUser(Register register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		//userRepository.findById(register.getId());
		if (userRepository.existsByEmailAndContactNumber(register.getEmail(), register.getContactNumber())==true) {
			throw new AlreadyExistsException("Already existing record");
		}
		
		Register register2 = userRepository.save(register);
		System.out.println(register2);
		System.out.println("test");
		if (register2!=null) {
//			return register2;
//		}
			System.out.println("Success");
			Login login = new Login(register.getFirstName(), register.getPassword(), register.getId());
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
	public Register getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional = userRepository.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Id not found");
		}
		else {
			return optional.get();
		}
		//return null;
	}

	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		List<Register> list = userRepository.findAll();
		Register[] array = new Register[list.size()];
		return userRepository.findAll().toArray(array);
		//return userRepository.getAllUsers();
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Register> optional = Optional.ofNullable(this.getUserById(id));
			if(optional.isEmpty()) {
				throw new IdNotFoundException("User not found");
			}
			else {
				userRepository.deleteById(id);
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
	
	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}