package com.zee.zee5app;

import java.util.Optional;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.*;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.impl.MovieServiceImpl;
import com.zee.zee5app.service.impl.SubscriptionServiceImpl;
import com.zee.zee5app.service.impl.UserServiceImpl;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.impl.SeriesServiceImpl;


public class Main {

	public static void main(String[] args) throws IdNotFoundException {
		// TODO Auto-generated method stub
		UserService service = UserServiceImpl.getInstance();
		SubscriptionService subservice = SubscriptionServiceImpl.getInstance();
		MovieService movservice = MovieServiceImpl.getInstance();
		SeriesService serservice = SeriesServiceImpl.getInstance();
		
		
		
		
		Register register = new Register(); 
		try {
			register.setFirstName("abhinandhan1");
			register.setLastName("chivate1");
		} catch (InvalidNameException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
			try {
				register.setPassword("abhi0000001");
			} catch (InvalidPasswordException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		try {
			register.setId("ab00000001");
			service.addUser(register);
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(register);
		
		System.out.println(register.getEmail());
		
		
		
		for(int i=1;i<=25;i++) {
			Register register2 = new Register();	
			
			try {
				register2.setId("ab0000000" + i);
				register2.setFirstName("abhinandhan" + i);
				register2.setLastName("chivate" + i);
				register2.setPassword("abhi" + i);
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (InvalidIdLengthException e) {
				e.printStackTrace();
			}
			catch(Exception e) {
				
			}
			catch(Throwable e) {
				
			}
			
		String result = service.addUser(register2);
		System.out.println(result);
		
		}
		
		
		
		
		
		
		String a = service.updateUser("ab00000008" , register );
		System.out.println(a);
//		
		String b = service.deleteUserById("ab00000002");
		System.out.println(b);
//		
		
		
		
		Movie movie = new Movie();
		movie.setMovie_id("1");
		movie.setMovie_category("comedy");
		movie.setMovie_hero("AA");
		movie.setMovie_language("telugu");
		movie.setMovie_length(2);
		movie.setMovie_name("pushpa");
		movie.setMovie_Release_Date("december");
		movie.setMovie_trailer("youtube.com");
		
		
		String out = movservice.addMovie(movie);
		
		String out1 = movservice.deleteMovieById("1");
		System.out.println(out);
		System.out.println(out1);
		
		
		
	Optional<Register> optional ;
	try {
		optional = service.getUserById("ab00000001");
		if(optional.isPresent()) {
			System.out.println("getUserById" + optional.get());
		}
		else {
			System.out.println("id not found");
		}
	} catch (IdNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	service.getAllUserDetails().forEach(e->System.out.println(e));
	
	
	}

}