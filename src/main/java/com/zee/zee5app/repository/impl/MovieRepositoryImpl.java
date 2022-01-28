package com.zee.zee5app.repository.impl;

import java.util.HashSet;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {
	private static MovieRepository repository;
	public static MovieRepository getInstance() {
		if(repository==null) {
			repository = new MovieRepositoryImpl();
		}
		return repository;
	}
	private HashSet<Movie> movies = new HashSet();
	//private static int count = -1;

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		boolean result= this.movies.add(movie);
		if (result==true) {
			return "Successfully added user";
		}
		return "Failed to add user";
	}

	@Override
	public String updateMovie(String id, Movie movie1) {
		// TODO Auto-generated method stub
		/*
		int count1 = 0;
		for (Movie movie : movies) {
			if(movie != null && movie.getMovieId().equals(id)) {
				movies[count1] = movie1;
				return("Completed");
			}
			count1++;
			
		}
		return("Not Completed");
		*/
		return null;
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException  {
		// TODO Auto-generated method stub
		Movie movie2 = null;
		for (Movie movie : movies) {
			if(movie.getMovieId().equals(id)) {
				movie2 = movie;
				break;
				//return Optional.of(register);			
			}
		}
			return Optional.of(Optional.ofNullable(movie2).orElseThrow(() -> new IdNotFoundException("ID not found")));
		
	}

	@Override
	public Movie[] getAllMovies() {
		// TODO Auto-generated method stub
		Movie movie[]= new Movie[movies.size()];
		
		return movies.toArray(movie);
	}

	@Override
	public String deleteMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> optional = this.getMovieById(id);
		if(optional.isPresent()) {
			//removal
			boolean result = movies.remove(optional.get());
			if (result) {
				return "Successfully deleted Movie";
				
			}
			else {
				return "Failed to delete Movie";
			}
		}
		/*
		 * else { //throw IdNotFoundException throw new
		 * IdNotFoundException("id not found for deletion");
		 * 
		 * }
		 */
		
		return "fail";
	}

}