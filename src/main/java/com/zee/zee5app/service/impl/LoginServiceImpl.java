package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
//import com.zee.zee5app.repository.impl.LoginRepositoryImpl;
import com.zee.zee5app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginRepository loginRepository;
	//private LoginRepository loginRepository = LoginRepositoryImpl.getInstance();
	
	private LoginServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	private static LoginService service;
	public static LoginService getInstance() throws IOException {
		if(service==null)
			service = new LoginServiceImpl();
		return service;
	}

	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Login login2 = loginRepository.save(login);
		if(login2!=null) {
			return "success";
		}
		else {
			return "fail";
		}
	}

	@Override
	public String deleteCredentials(String username) {
		// TODO Auto-generated method stub
		try {
			Optional<Login> optional = loginRepository.findById(username);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("User credentials not found");
			}
			else {
				loginRepository.deleteById(username);
				return "successfully deleted user credentials";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new IdNotFoundException(e.getMessage());
		}
		return null;
	}

	@Override
	public String changePassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeRole(String username, ROLE role) {
		// TODO Auto-generated method stub
		return null;
	}


}