package com.zee.zee5app;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Register register = new Register("a1", "abhinandan", "chivate", "abhi@gmail.com", "123456");
			
			System.out.println(register);
			System.out.println(register.toString());
			System.out.println(register.hashCode());
			Register register2 = new Register("a1", "abhinandan", "chivate", "abhi@gmail.com", "123456");
			System.out.println(register2);
			System.out.println(register2.toString());
			System.out.println(register2.hashCode());
			System.out.println(register);
			System.out.println(register.toString());
			System.out.println(register.hashCode());
			System.out.println("equals method call"+register.equals(register2));
			
		} catch (InvalidNameException | InvalidIdLengthException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
