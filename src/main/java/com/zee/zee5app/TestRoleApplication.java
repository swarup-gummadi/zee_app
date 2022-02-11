package com.zee.zee5app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.service.RoleService;

//@SpringBootApplication
public class TestRoleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(TestRoleApplication.class, args);
		
		RoleService roleService = applicationContext.getBean(RoleService.class);
		Role role = new Role();
		role.setRoleName(EROLE.ROLE_ADMIN);
		Role role2 = new Role();
		role2.setRoleName(EROLE.ROLE_USER);
		System.out.println(roleService.addRole(role));
		System.out.println(roleService.addRole(role2));
		
		applicationContext.close();
	}

}
