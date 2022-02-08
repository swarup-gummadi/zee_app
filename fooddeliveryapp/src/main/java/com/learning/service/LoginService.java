package com.learning.service;

import com.learning.dto.Login;

public interface LoginService {

	public String addCredentials(Login login);
	public String deleteCredentials(String email);
	public String changePassword(String email,String password);
	public String vaidateCredentials(Login login);
}
