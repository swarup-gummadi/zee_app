package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
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
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
	public User addUser(User register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if(userRepository.existsByEmailAndContactNumber(register.getEmail(), register.getContactNumber())) {
			throw new AlreadyExistsException("This record already exists");
		}
		User register2 = userRepository.save(register);
		if (register2!=null) {
			Login login = new Login(register2.getEmail(), register2.getPassword(), register2.getId());
			if (loginRepository.existsByUsername(login.getUsername())) {
				throw new AlreadyExistsException("This record already exists");
			}
			String result = loginService.addCredentials(login);
			if (result.equals("Success"))
				return register2;
			else
				return null;
		}
		else
			return null;
	}
	
	@Override
	public Optional<User> getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public User[] getAllUsers() {
		// TODO Auto-generated method stub
		List<User> list = userRepository.findAll();
		User[] registers = new User[list.size()];
		return list.toArray(registers);
	}

	@Override
	public String deleteUserById(long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> optional = this.getUserById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException("Record not found");
		else {
			userRepository.deleteById(id);
			return "Success";
		}
	}
	
	@Override
	public Optional<List<User>> getAllUserDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}

	@Override
	public Optional<User> getUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
