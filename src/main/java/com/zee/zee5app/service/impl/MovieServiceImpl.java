package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.MovieRepository;
//import com.zee.zee5app.repository.impl.MovieRepositoryImpl;
import com.zee.zee5app.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	DataSource dataSource;
	private MovieRepository movieRepository;
	//private MovieRepository movieRepository = MovieRepositoryImpl.getInstance();
	private MovieServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	private static MovieService movieService;
	public static MovieService getInstance() throws IOException {
		if(movieService==null)
			movieService = new MovieServiceImpl();
		return movieService;
	}

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		Movie movie2 = movieRepository.save(movie);
		if (movie2!=null) {
			return "Success";
		}
		else {
			return "Fail";
		}
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return movieRepository.findById(id);
	}

	@Override
	public Movie[] getAllMovies() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		List<Movie> list = movieRepository.findAll();
		Movie[] array = new Movie[list.size()];
		return movieRepository.findAll().toArray(array);
	}

	

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Movie> optional = this.getMovieById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("Movie not found");
			}
			else {
				movieRepository.deleteById(id);
				return "successfully deleted movie";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Movie>> getAllMovieDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepository.findAll());
	}

	@Override
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}