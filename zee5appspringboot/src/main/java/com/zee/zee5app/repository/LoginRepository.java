package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;

public interface LoginRepository {
	
	public String addCredentials(Login login);
	public String deleteCredentials(String username);
	public String changePassword(String userName, String password);
	public String changeRole(String username, ROLE role);
	public String updateCredentials(String regId, Login login);

}