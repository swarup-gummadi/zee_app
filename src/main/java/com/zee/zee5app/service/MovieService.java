package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;

public interface MovieService {
	
	public String addMovie(Movie movie);
	public Optional<Movie> getMovieById(String id);
	public Movie[] getAllMovies();
	public String deleteMovie(String id) throws IdNotFoundException;
	public Optional<List<Movie>> getAllMovieDetails();

}
