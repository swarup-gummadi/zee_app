package com.zee.zee5app;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext= SpringApplication.run(Zee5appspringbootApplication.class, args);
		
		//DataSource dataSource = applicationContext.getBean(DataSource.class);
		
		//System.out.println(dataSource!=null);
		
		//
		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		
		
		//UserService service = UserServiceImpl.getInstance();
		Register register = new Register("ab00010", "Swarup10", "GUMMADI10", "swar10@test.com", "LUL837712", null);
		//register.setContactNumber(new BigDecimal("9218399211"));
		
		Register register2 = new Register("ab00011", "Swarup11", "GUMMADI11", "swar11@test.com", "LUL837712", null);
		//register2.setContactNumber(new BigDecimal("9218399211"));
		userRepository.save(register);
		userRepository.save(register2);
		//System.out.println(result);
		applicationContext.close();
	
	
	}

}
