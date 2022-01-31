package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;

public class UserRepositoryImpl implements UserRepository {
	
	LoginRepository loginRepository = LoginRepositoryImpl.getInstance();
	DBUtils dbUtils = DBUtils.getInstance();
	
	private UserRepositoryImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	private static UserRepository repository;
	public static UserRepository getInstance() throws IOException {
		if(repository==null)
			repository = new UserRepositoryImpl();
		return repository;
	}
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		
		String insertStatement = "INSERT INTO register"
				+ " (regId, firstName, lastName, email, contactNumber, password)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, register.getId());
			preparedStatement.setString(2, register.getFirstName());
			preparedStatement.setString(3, register.getLastName());
			preparedStatement.setString(4, register.getEmail());
			preparedStatement.setBigDecimal(5, register.getContactNumber());
			String salt = PasswordUtils.getSalt(30);
			String encryptedPassword = PasswordUtils.generateSecurePassword(register.getPassword(), salt);
			preparedStatement.setString(6, encryptedPassword);
			
			int result = preparedStatement.executeUpdate();
			
			if (result>0) {
				Login login = new Login();
				login.setUsername(register.getEmail());
				login.setPassword(encryptedPassword);
				login.setRegId(register.getId());
				login.setRole(ROLE.ROLE_USER);
				String res = loginRepository.addCredentials(login);
				if(res.equals("Success"))
					return "Success";
				else {
					connection.rollback();
					return "Fail";
				}
			}
			else {
				connection.rollback();
				return "Fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Fail";
		}
		finally {
			dbUtils.closeConnection(connection);
		}
	}
	
	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		
		String updateStatement = "UPDATE register"
				+ " SET regId = ?, firstName = ?, lastName = ?, email = ?, contactNumber = ?, password = ?"
				+ " WHERE (regId = ?)";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, register.getId());
			preparedStatement.setString(2, register.getFirstName());
			preparedStatement.setString(3, register.getLastName());
			preparedStatement.setString(4, register.getEmail());
			preparedStatement.setBigDecimal(5, register.getContactNumber());
			String salt = PasswordUtils.getSalt(30);
			String encryptedPassword = PasswordUtils.generateSecurePassword(register.getPassword(), salt);
			preparedStatement.setString(6, encryptedPassword);
			preparedStatement.setString(7, id);
			
			int result = preparedStatement.executeUpdate();
			
			if (result>0) {
				Login login = new Login();
				login.setUsername(register.getEmail());
				login.setPassword(encryptedPassword);
				login.setRegId(register.getId());
				login.setRole(ROLE.ROLE_USER);
				String res = loginRepository.updateCredentials(register.getId(), login);
				if(res.equals("Success"))
					return "Success";
				else {
					connection.rollback();
					return "Fail";
				}
			}
			else {
				connection.rollback();
				return "Fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Fail";
		}
		finally {
			dbUtils.closeConnection(connection);
		}
	}
	
	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		String selectStatement = "SELECT * FROM register WHERE regId=?";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				Register register = new Register();
				register.setId(resultSet.getString("regId"));
				register.setFirstName(resultSet.getString("firstName"));
				register.setLastName(resultSet.getString("lastname"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				register.setContactNumber(resultSet.getBigDecimal("contactnumber"));
				return Optional.of(register);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
	}
	
	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		Optional<List<Register>> optional = getAllUserDetails();
		if (optional.isEmpty())
			return null;
		else {
			List<Register> list = optional.get();
			Register[] registers = new Register[list.size()];
			return list.toArray(registers);
		}
	}
	
	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		
		String deleteStatement = "DELETE FROM register WHERE regId=?";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);
			
			int result = preparedStatement.executeUpdate();
			
			if (result>0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "Fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Fail";
		}
		finally {
			dbUtils.closeConnection(connection);
		}
	}
	
	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<Register> arrayList = new ArrayList<Register>();
		
		String selectStatement = "SELECT * FROM register";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Register register = new Register();
				register.setId(resultSet.getString("regId"));
				register.setFirstName(resultSet.getString("firstName"));
				register.setLastName(resultSet.getString("lastname"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				register.setContactNumber(resultSet.getBigDecimal("contactnumber"));
				arrayList.add(register);
			}
			return Optional.ofNullable(arrayList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
	}

}