package com.zee.zee5app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.PLAN_STATUS;
import com.zee.zee5app.dto.PLAN_TYPE;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.SeriesService;

@SpringBootApplication
public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class, args);
//		UserRepository userRepository= applicationContext.getBean(UserRepository.class);
//		UserService userService= applicationContext.getBean(UserService.class);
//		Register register = new Register("ab00010", "Swarup10", "GUMMADI10", "swar10@test.com", "LUL837712", new BigDecimal("9827178381"),null,null );
//		
//		Register register2 = new Register("ab00011", "Swarup11", "GUMMADI11", "swar11@test.com", "LUL837712", null, null, null);
//		
//		try {
//			userService.addUser(register2);
//		} catch (AlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(userRepository.existsByEmail("swar10@test.com"));
//		System.out.println(userRepository.existsByEmailAndContactNumber("swar10@test.com",new BigDecimal("9827178381") ));
//		
//		MovieService movieService = applicationContext.getBean(MovieService.class);
//		//MovieRepository movieRepository = applicationContext.getBean(MovieRepository.class);
//		
////		FileInputStream fileInputStream = null;
////		FileOutputStream fileOutputStream =null;
////		Movie movie = new Movie();//"mov0001", "Spiderman", 8, "Tom, Zendaya", "Action", null, new Date(2021-12-25), "English");
////		movie.setId("mov0001");
////		movie.setName("Spiderman");
////		movie.setAgeLimit(8);
////		movie.setCast("Tom");
////		movie.setGenre("Action");
////		movie.setReleaseDate(new Date(20));
////		movie.setLanguage("English");
////		try {
////			fileInputStream = new FileInputStream("C:\\movies\\trailer1.mp4");
////			File file= new File("C:\\movies\\trailer1.mp4");
////			long fileSize = file.length();
////			byte[] allBytes = new byte[(int) fileSize];
////			
////			movie.setTrailer("C:\\movies\\movieStore\\"+file.getName());
////			Movie result = movieService.addMovie(movie);
////			if(result.equals("Success")) {
////				fileOutputStream = new FileOutputStream("C:\\movies\\movieStore\\"+file.getName());
////
////				fileInputStream.read(allBytes);
////				fileOutputStream.write(allBytes);
////			}
////		} catch (IOException e1) {
////			// TODO Auto-generated catch block
////			e1.printStackTrace();
////		}
////		finally {
////			try {
////				fileInputStream.close();
////			} catch (Exception e) {
////				// TODO: handle exception
////			}
////		}
////		
////		
////		//System.out.println(movieRepository.existsByName("Spiderman"));
////		//System.out.println(movieRepository.findByNameAndLanguage("Spiderman", "English"));
////		
////		FileOutputStream fileOutputStream = null;
////		try {
////			Optional<Movie> optional = movieService.getMovieById("mov0001");
////			if(optional.isEmpty()) {
////				System.out.println("Movie not found");
////			}
////			else {
////				// print the info and copy the file into a folder with name trailers
////				Movie movie1 = optional.get();
////				fileOutputStream = new FileOutputStream("C:\\movies\\read\\read_trailer1.mp4");
////				fileOutputStream.write(movie1.getTrailer());
////				
////			}
////		} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException | IOException e1) {
////			// TODO Auto-generated catch block
////			e1.printStackTrace();
////		}
////		finally {
////			try {
////				fileOutputStream.close();
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
//		
//		
//		SeriesRepository seriesRepository = applicationContext.getBean(SeriesRepository.class);
//		Series series = new Series("ser001", "AOT", 12, "", "Eren", "Action", new Date(2022-01-10), "Japanese", 15 , null);
//		seriesRepository.save(series);
//		//System.out.println(seriesRepository.findByNameAndLanguage("AOT", "Japanese"));
//		
//		RoleService roleService = applicationContext.getBean(RoleService.class);
//		RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
//		Role role = new Role();
//		role.setRoleName(EROLE.ROLE_ADMIN);
//		
//		Role role2 = new Role();
//		role2.setRoleName(EROLE.ROLE_USER);
//		System.out.println(roleService.addRole(role));
//		System.out.println(roleService.addRole(role2));
//		
//		Set<Role> roles = new HashSet<>();
//		roles.add(roleRepository.findById(1).get());
//		roles.add(roleRepository.findById(2).get());
//		register.setRoles(roles);
//		try {
//			System.out.println(userService.addUser(register));
//		} catch (AlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		Episode episode = new Episode("E0001", "Beginning", 120f, "Drive", "url", series);
//		EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
//		episodeService.addEpisode(episode);
//		
//		FileInputStream fileInputStream1 = null;
//		FileOutputStream fileOutputStream1 =null;
//		
//		try {
//			fileInputStream1 = new FileInputStream("C:\\episodes\\trailer1.mp4");
//			File file= new File("C:\\episodes\\trailer1.mp4");
//			long fileSize = file.length();
//			byte[] allBytes = new byte[(int) fileSize];
//			
//			episode.setTrailer("C:\\episodes\\episodeStore\\"+file.getName());
//			String result = episodeService.addEpisode(episode);
//			if(result.equals("Success")) {
//				fileOutputStream1 = new FileOutputStream("C:\\episodes\\episodeStore\\"+file.getName());
//
//				fileInputStream1.read(allBytes);
//				fileOutputStream1.write(allBytes);
//			}
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		finally {
//			try {
//				fileInputStream1.close();
//				fileOutputStream1.close();
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//		
//		Subscription subscription = new Subscription("sub0001", new Date(2012-12-02), new Date(1), 499f, "DEBIT CARD", "STATUS_ACTIVE", "TYPE_PREMIUM", "No", register);
//		SubscriptionService subscriptionService = applicationContext.getBean(SubscriptionService.class);
//		subscriptionService.addSubscription(subscription);
//		//applicationContext.close();
	}

}
