package com.zee.zee5app;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		
		ConfigurableApplicationContext applicationContext= SpringApplication.run(Zee5appspringbootApplication.class, args);
		
		//DataSource dataSource = applicationContext.getBean(DataSource.class);
		
		//System.out.println(dataSource!=null);
		
		//
		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		UserService userService = applicationContext.getBean(UserService.class);
		
		
		//UserService service = UserServiceImpl.getInstance();
		Register register = new Register("ab00010", "Swarup10", "GUMMADI10", "swar10@test.com", "LUL837712", null);
		//register.setContactNumber(new BigDecimal("9218399211"));
		
		Register register2 = new Register("ab00011", "Swarup11", "GUMMADI11", "swar11@test.com", "LUL837712", null);
		//register2.setContactNumber(new BigDecimal("9218399211"));
		userRepository.save(register);
		userRepository.save(register2);
		//System.out.println(result);
		
		System.out.println("Get User by Id");
		System.out.println(userService.getUserById("reg0004").get());
		System.out.println();
		
		System.out.println("Get All User Details - List");
		userService.getAllUserDetails().get().forEach(e->System.out.println(e));
		System.out.println();
		
		System.out.println("Delete Record by Id");
		try {
			System.out.println(userService.deleteUserById("reg0003"));
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println();
		
		System.out.println("Get All User Details - Array");
		for (Register register1 : userService.getAllUsers()) {
			System.out.println(register1);
		}
		System.out.println();
		
		/*
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(TestSubscriptionApplication.class, args);
		
		SubscriptionService subscriptionService = applicationContext.getBean(SubscriptionService.class);
		System.out.println("Add Subscription");
		for (int i = 1; i <= 5; i++) {
			Subscription subscription = new Subscription("sub000"+i, "2022-03-0"+i, "2023-03-0"+i, 2000+i, "credit"+i, "yearly"+i, "active"+i, "true"+i, "reg000"+i);
			System.out.println(subscriptionService.addSubscription(subscription) + " " + i);
		}
		System.out.println();
		
		System.out.println("Get Subscriptions by Id");
		System.out.println(subscriptionService.getSubscriptionById("sub0004").get());
		System.out.println();
		
		System.out.println("Get list Subscription Details");
		subscriptionService.getAllSubscriptionDetails().get().forEach(e->System.out.println(e));
		System.out.println();
		
		System.out.println("Delete Subscription by Id");
		try {
			System.out.println(subscriptionService.deleteSubscription("sub0003"));
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println();
		
		System.out.println("Get array Subscription Details");
		for (Subscription subscription : subscriptionService.getAllSubscriptions()) {
			System.out.println(subscription);
		}
		System.out.println();
		
		//
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(TestSeriesApplication.class, args);
		
		SeriesService seriesService = applicationContext.getBean(SeriesService.class);
		System.out.println("Add Series");
		for (int i = 1; i <= 5; i++) {
			Series series = new Series("ser000"+i, "SeriesName"+i, 5+i, null, "Cast"+i, "Genre"+i, "2022-04-0"+i, "Language"+i, 18+i);
			System.out.println(seriesService.addSeries(series) + " " + i);
		}
		System.out.println();
		
		System.out.println("Get Series by Id");
		System.out.println(seriesService.getSeriesById("ser0004").get());
		System.out.println();
		
		System.out.println("Get All Series Details - List");
		seriesService.getAllSeriesDetails().get().forEach(e->System.out.println(e));
		System.out.println();
		
		System.out.println("Delete Series by Id");
		try {
			System.out.println(seriesService.deleteSeries("ser0003"));
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println();
		
		System.out.println("Get All Series Details - Array");
		for (Series series : seriesService.getAllSeries()) {
			System.out.println(series);
		}
		System.out.println();
		
		//
		  
		 ConfigurableApplicationContext applicationContext =
				SpringApplication.run(TestMovieApplication.class, args);
		
		MovieService movieService = applicationContext.getBean(MovieService.class);
		System.out.println("Add Movie");
		for (int i = 1; i <= 5; i++) {
			Movie movie = new Movie("mov000"+i, "MovieName"+i, 5+i, "Cast"+i, "Genre"+i, 120+i, "Link"+i, "2022-04-0"+i, "Language"+i);
			System.out.println(movieService.addMovie(movie) + " " + i);
		}
		System.out.println();
		
		System.out.println("Get Movie by Id");
		System.out.println(movieService.getMovieById("mov0004").get());
		System.out.println();
		
		System.out.println("Get All Movie Details - List");
		movieService.getAllMovieDetails().get().forEach(e->System.out.println(e));
		System.out.println();
		
		System.out.println("Delete Movie by Id");
		try {
			System.out.println(movieService.deleteMovie("mov0003"));
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println();
		
		System.out.println("Get All Movie Details - Array");
		for (Movie movie : movieService.getAllMovies()) {
			System.out.println(movie);
		}
		System.out.println();
		 */
		
		
		applicationContext.close();
	
	
	}

}
