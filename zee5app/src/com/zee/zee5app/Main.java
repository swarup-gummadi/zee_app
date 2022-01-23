package com.zee.zee5app;

import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.userRepo;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) throws IdNotFoundException {
		// TODO Auto-generated method stub

		Register register = new Register();

		// Register register6 = new Register(id, firstName, lastName, email, password);
		// Register: Class name
		// register: reference which will refer your object
		// new: is used to create the object
		// Register(): constructor(Default)

		register.setEmail("swarup@gmail.com");
		register.setPassword("1234");
		try {
			register.setFirstName("swarup");
			register.setLastName("gummadi");
			register.setId("S3");
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNameException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println(register);
		System.out.println(register.toString());
		// Above two prints have same output because print will call the toString()
		// method

		System.out.println(register.getEmail());

		// Login login = new Login();

		UserService service = UserServiceImpl.getInstance();

		 for (int i=1; i<=11; i++) { 
			 Register register2 = new Register();
			 try {
				register2.setId("S"+i);
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 try {
				register2.setFirstName("Swarup"+i);
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 String result = service.addUser(register2); 
			 System.out.println(result);
		 }
		 
		 for (int i=1; i<=11; i++) { 
			 Register register2 = new Register();
			 try {
				register2.setId("S"+i);
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 try {
				register2.setFirstName("Swarup"+i);
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 String result = service.addUser(register2); 
			 System.out.println(result);
		 }
		 //System.out.println(register2); }
		 
		// System.out.println(register);
		// String result = service.addUser(register);
		// System.out.println(result);

		// Register register2 = service.getUserByID("S4");
		// System.out.println(register2);

		/*
		 * for(Register register3: service.getAllUsers()) { if (register3!=null)
		 * System.out.println(register3); }
		 */

		// Register[] result = service.getAllUsers();

		/*
		 * Register register3 = new Register(); register3.setId("S4");
		 * register3.setFirstName("Swar_Update"); register3.setLastName("updated");
		 * String result = service.updateUser("S4", register3);
		 * System.out.println(result);
		 */

		/*
		 * for (Register register4 : service.getAllUsers()) { if (register4 != null)
		 * System.out.println(register4); }
		 */
		/*
		 * Register register2 = service.getUserByID("S4");
		 * System.out.println(register2);
		 */

		// Interface
		//userRepo repository = null;
		
			 
		try {
			Optional<Register> optional =service.getUserById("S1");
			if(optional.isPresent()) {
				System.out.println("getUserById"+ optional.get());
				
			}
			else {
				System.out.println("Id not found");
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch blockS
			e.printStackTrace();
		}
		
		
		//service.getAllUserDetails().forEach(e -> System.out.println(e));
		
		//service.deleteUserById("S2");
		service.getAllUserDetails().forEach(e -> System.out.println(e));
		
		
	}

}

