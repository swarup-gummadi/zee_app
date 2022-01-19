package com.zee.zee5app;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.UserService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Register register = new Register();
		//Register: Class name
		//register: reference which will refer your object
		//new: is used to create the object
		// Register(): constructor(Default)
		
		register.setFirstName("swarup");
		register.setLastName("gummadi");
		register.setEmail("swarup@gmail.com");
		register.setPassword("1234");
		
		System.out.println(register);
		System.out.println(register.toString());
		//Above two prints have same output because print will call the toString() method
		
		System.out.println(register.getEmail());
		
		//Login login = new Login();
		
		UserService service = UserService.getInstance();
		
		for (int i=1; i<=11; i++) {
			Register register2 = new Register();
			register2.setId("S"+i);
			register2.setFirstName("Swarup"+i);
			String result = service.addUser(register2);
			System.out.println(result);
			//System.out.println(register2);
		}
		//System.out.println(register);
		//String result = service.addUser(register);
		//System.out.println(result);
		
		//Register register2 = service.getUserByID("S4");
		//System.out.println(register2);
		
		/*
		for(Register register3: service.getAllUsers()) {
			if (register3!=null)
			System.out.println(register3);
		}
		*/
		
		//Register[] result = service.getAllUsers();
		
		Register register3 = new Register();
		register3.setId("S4");
		register3.setFirstName("Swar_Update");
		register3.setLastName("updated");
		String result = service.updateUser("S4", register3);
		System.out.println(result);
		
		for(Register register4: service.getAllUsers()) {
			if (register4!=null)
			System.out.println(register4);
		}
		
		Register register2 = service.getUserByID("S4");
		System.out.println(register2);
	}

}
