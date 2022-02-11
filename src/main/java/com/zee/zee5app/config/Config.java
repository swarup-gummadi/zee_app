package com.zee.zee5app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zee.zee5app.utils.PasswordUtils;

@Configuration
public class Config {
	
//	@Autowired
//	Environment environment;
	
//	@Bean
//	@Scope("singleton")
//	public DataSource dataSource() {
//		BasicDataSource basicDataSource = new BasicDataSource();
//		
//		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
//		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
//		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
//		basicDataSource.setDefaultAutoCommit(false);
//		
//		return basicDataSource;
//	}
	
	@Bean
	public PasswordUtils passwordUtils() {
		return new PasswordUtils();
	}

}
