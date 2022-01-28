package com.zee.zee5app.service.impl;

import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.impl.MovieRepositoryImpl;
import com.zee.zee5app.service.MovieService;

public class MovieServiceImpl implements MovieService {
	private static MovieService service;
	public static MovieService getInstance() {
		if(service==null) {
			service = new MovieServiceImpl();
		}
		return service;
	}
	
	MovieRepository movieRepository = MovieRepositoryImpl.getInstance();

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepository.addMovie(movie);
	}

	@Override
	public String updateMovie(String id, Movie movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.updateMovie(id, movie);
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.getMovieById(id);
	}

	@Override
	public Movie[] getAllMovies() {
		return movieRepository.getAllMovies();
	}

	@Override
	public String deleteMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.deleteMovieById(id);
	}


}