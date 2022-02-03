package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.UserService;
//import com.zee.zee5app.service.seriesService;

@SpringBootApplication
public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class, args);
		UserRepository userRepository= applicationContext.getBean(UserRepository.class);
		UserService userService= applicationContext.getBean(UserService.class);
		Register register = new Register("ab00010", "Swarup10", "GUMMADI10", "swar10@test.com", "LUL837712", new BigDecimal("9827178381"),null );
		
		Register register2 = new Register("ab00011", "Swarup11", "GUMMADI11", "swar11@test.com", "LUL837712", null, null);
		
		try {
			userService.addUser(register2);
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(userRepository.existsByEmail("swar10@test.com"));
		System.out.println(userRepository.existsByEmailAndContactNumber("swar10@test.com",new BigDecimal("9827178381") ));
		
		MovieRepository movieRepository = applicationContext.getBean(MovieRepository.class);
		Movie movie = new Movie("mov0001", "Spiderman", 8, "Tom, Zendaya", "Action", "link", new Date(2021-12-25), "English");
		movieRepository.save(movie);
		System.out.println(movieRepository.existsByName("Spiderman"));
		System.out.println(movieRepository.findByNameAndLanguage("Spiderman", "English"));
		
		SeriesRepository seriesRepository = applicationContext.getBean(SeriesRepository.class);
		Series series = new Series("ser001", "AOT", 12, "", "Eren", "Action", new Date(2022-01-10), "Japanese", 15 , null);
		seriesRepository.save(series);
		//System.out.println(seriesRepository.findByNameAndLanguage("AOT", "Japanese"));
		
		RoleService roleService = applicationContext.getBean(RoleService.class);
		RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
		Role role = new Role();
		role.setRoleName(EROLE.ROLE_ADMIN);
		
		Role role2 = new Role();
		role2.setRoleName(EROLE.ROLE_USER);
		System.out.println(roleService.addRole(role));
		System.out.println(roleService.addRole(role2));
		
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findById(1).get());
		roles.add(roleRepository.findById(2).get());
		register.setRoles(roles);
		try {
			System.out.println(userService.addUser(register));
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Episode episode = new Episode("E0001", "Beginning", 120f, "Drive", "url", series);
		EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
		episodeService.addEpisode(episode);
		
		applicationContext.close();
	}

}
