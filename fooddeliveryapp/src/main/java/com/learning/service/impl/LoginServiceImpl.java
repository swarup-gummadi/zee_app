package com.learning.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dto.Login;
import com.learning.dto.Register;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.LoginRepository;
import com.learning.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
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
	public String deleteCredentials(String email) {
		// TODO Auto-generated method stub
		try {
			Optional<Login> optional = loginRepository.findById(email);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("User credentials not found");
			}
			else {
				loginRepository.deleteById(email);
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
	public String changePassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String vaidateCredentials(Login login) {
		// TODO Auto-generated method stub
		Login login2 = new Login();
		Register register2 = new Register();
		
		if(login.getEmail()==register2.getEmail() && login.getPassword()==register2.getPassword()) {
			return "successfully validated";
		}
		else
			return "failed";
	}

}
