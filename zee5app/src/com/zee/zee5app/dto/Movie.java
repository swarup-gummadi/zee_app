package com.zee.zee5app.dto;

import com.zee.zee5app.exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data


public class Movie {
	private String movie_id;
	private String movie_name;
	private String movie_category;
	private String movie_Release_Date;
	private String movie_trailer;
	private String movie_language;
	private String movie_hero;
	private int movie_length;
	@Setter(value = AccessLevel.NONE)
	private String movie_location;
	
	public  Movie() {
		
		
		
	}

	
		public void setmovie_location(String movie_location) throws LocationNotFoundException {
			if(movie_location.length() < 5) {
				throw new LocationNotFoundException("the location is not specified");
			}
		this.movie_location = movie_location;
	}
	
}