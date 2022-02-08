package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;

public interface MovieService {
	
	public Movie addMovie(Movie movie) throws AlreadyExistsException;
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException;
	public Movie[] getAllMovies() throws InvalidIdLengthException, InvalidNameException;
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException;
	public String deleteMovie(String id) throws IdNotFoundException;
	public Optional<List<Movie>> getAllMovieDetails() throws InvalidIdLengthException, InvalidNameException;

}