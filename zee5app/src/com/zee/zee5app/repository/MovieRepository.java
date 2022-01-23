package com.zee.zee5app.repository;

import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;

public interface MovieRepository {
	public String addMovie(Movie movie);
	public String updateMovie(String id, Movie movie);
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException;
	public Movie[] getAllMovies();
	public String deleteMovieById(String id) throws IdNotFoundException;


}