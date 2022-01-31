package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.LoginServiceImpl;
import com.zee.zee5app.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UserService service = UserServiceImpl.getInstance();
			Register register = new Register("ab00002", "Swarup", "GUMMADI", "swar2@test.com", "LUL1212", null);
			register.setContactNumber(new BigDecimal("9218399211"));
			String result = service.addUser(register);
			System.out.println(result);
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			UserService service = UserServiceImpl.getInstance();
//			Optional<Register> register = service.getUserById("ab00001");
//			System.out.println(register.get());
//		} catch (IOException | IdNotFoundException | InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			UserService service = UserServiceImpl.getInstance();
//			String result = service.deleteUserById("ab00006");
//			System.out.println(result);
//		} catch (IdNotFoundException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			UserService service = UserServiceImpl.getInstance();
//			Optional<List<Register>> optional = service.getAllUserDetails();
//			if(optional.isEmpty())
//				System.out.println("There is no records");
//			else
//				optional.get().forEach(e->System.out.println(e));
//			
//		} catch (IOException | InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			UserService service = UserServiceImpl.getInstance();
//			Register register = new Register("ab00006", "swarup6", "gummadi2", "swar6@gmail.com", "jask125", null);
//			register.setContactNumber(new BigDecimal("9328374872"));
//			String result = service.updateUser("ab00006", register);
//			System.out.println(result);
//		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException | IOException | IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}