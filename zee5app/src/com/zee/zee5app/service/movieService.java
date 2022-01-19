package com.zee.zee5app.service;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.repository.movieRepo;

public class movieService {
	movieRepo movierepo=movieRepo.getInstance();
	private movieService() {
		// TODO Auto-generated constructor stub
	}
	private static movieService movieservice=null;
	public static movieService getInstance()
	{
		if(movieservice==null)
			movieservice=new movieService();
		return movieservice;
	}
	public String addMovie(Movies movie)
	{
		return this.movierepo.addMovie(movie);
	}
	public Movies getMovieById(String id)
	{
		return this.movierepo.getMovieById(id);
	}
	public Movies[] getAllUsers()
	{
		return this.movierepo.getMovies();
	}
	public String modifyMovie(String id,Movies movie)
	{
		return this.movierepo.modifyMovie(id, movie);
	}
}