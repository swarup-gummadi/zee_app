package com.zee.zee5app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.service.LoginService;

//@SpringBootApplication
public class TestLoginApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(TestLoginApplication.class, args);
		
		LoginService loginService = applicationContext.getBean(LoginService.class);
		System.out.println("Add Login");
		for (int i = 1; i <= 5; i++) {
			Login login = new Login("rithwik"+i+"@gmail.com", "rith123"+i, "reg000"+i);
			System.out.println(loginService.addCredentials(login) + " " + i);
		}
		System.out.println();
		
		System.out.println("Delete Login by Email");
		try {
			System.out.println(loginService.deleteCredentials("rithwik3@gmail.com"));
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println();
		
		applicationContext.close();
	}

}
