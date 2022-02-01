package com.zee.zee5app.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.zee.zee5app.utils.PasswordUtils;

@Configuration	// it is used to mark as config class/classes
//here we hold all commonly required objects for the application
//@ComponentScan("com.zee.zee5app")
//@PropertySource("classpath:application.properties")	//it is responsible to read the property file

public class Config {

	@Autowired	//will bring already created objects based on the name/type
	Environment environment;	//this impl object is prepared by Spring
	//config: DB related, reading prop file, commonly required beans i.e. passwordEncoder
	
//	@Bean(name = "ds")	//for providing the singleton object for methods
//	//if we do not mention the bean name, it will consider the name as method name
//	
//	@Scope("singleton")	// to get multiple objects we use prototype scope
//	//to get single instance of the object we use singleton scope
//	
//	public DataSource dataSource() {
//		
//		BasicDataSource basicDataSource = new BasicDataSource();
//		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
//		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
//		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
//		
//		//test
//		try {
//			basicDataSource.getConnection().setAutoCommit(false);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return basicDataSource;
//	}
	
	@Bean
	public PasswordUtils passwordUtils(){
		return new PasswordUtils();
	}
}
