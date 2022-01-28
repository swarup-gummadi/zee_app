package com.zee.zee5app.repository.impl;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.utils.DBUtils;

public class UserRepositoryImpl implements UserRepository {
	
	DBUtils dbUtils = DBUtils.getInstance();
	
	private UserRepositoryImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
	private static UserRepository repository;
	
	public static UserRepository getInstance() throws IOException {
		if(repository==null) {
			repository = new UserRepositoryImpl();
		}
		return repository;
	}

	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		// add the user details to the table.
		String insertStatement = "insert into register"
				+ " (regId,firstname,lastname,email,contactnumber,password)"
				+ " values(?,?,?,?,?,?)";
		// we will concatenate the values in values spec
		// we will use ? 
		// here we will provide the values against ? (placeholder)
		
		// Connection object
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			
			// do we need to provide the values against ? placeholder?
			preparedStatement.setString(1,register.getId());
			preparedStatement.setString(2, register.getFirstName());
			preparedStatement.setString(3, register.getLastName());
			preparedStatement.setString(4, register.getEmail());
			preparedStatement.setBigDecimal(5, register.getContactNumber());
			preparedStatement.setString(6, register.getPassword());
			
			int result =preparedStatement.executeUpdate();
			// the no of rows afftected by the DML statement
			// 1 : one row is inserted
			// 
			
			if(result>0) {
				return "success"	;
			}
			else
				return "fail";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		finally {
			// closure work 
			// closing the connection
			dbUtils.closeConnection(connection);
		}
		
		
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String selectStatement = "select * from register where regId=?";
		
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			
			// to retrieve the data
			// RS will hold the complete result
			
			resultSet =  preparedStatement.executeQuery();
			
			// RS object its a single one which is holding all the records
			// do we need to traverse it? ===> yes
			// 
			if (resultSet.next()) {
				// next method is used to traverse the RS
				/// initially RS will be places just above the 1st rec.
				// when u will call 1st time rs will retrieve the 1st rec & 
				// it will refer the 2nd one.
				Register register = new Register();
				register.setId(resultSet.getString("regId"));
				register.setFirstName(resultSet.getString("firstname"));
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
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Register> getAllUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

		
}