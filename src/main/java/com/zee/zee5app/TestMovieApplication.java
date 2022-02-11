package com.zee.zee5app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.service.MovieService;

//@SpringBootApplication
public class TestMovieApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(TestMovieApplication.class, args);
		
		MovieService movieService = applicationContext.getBean(MovieService.class);
//		FileUtils fileUtils = applicationContext.getBean(FileUtils.class);
//		String des = "C:\\Users\\rithwik.chithreddy\\Downloads\\movieStore";
		System.out.println("Add Movie");
		for (int i = 1; i <= 5; i++) {
			Movie movie = new Movie("mov000"+i, "MovieName"+i, 5+i, "Cast"+i, "Genre"+i, 120+i, null, "2022-04-0"+i, "Language"+i);
//			movie.setTrailer(des);
//			String src = "C:\\Users\\rithwik.chithreddy\\Downloads\\pushpa trailer.mp4";
//			
//			String result = movieService.addMovie(movie);
//			if (result.equals("Success")) {
//				File file = new File(src);
//				byte[] data = null;
//				try {
//					data = fileUtils.readFile(file);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				fileUtils.writeFile(data, des + file.getName());
//			}
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
		
		applicationContext.close();
	}

}
