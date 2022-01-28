package com.zee.zee5app.dto;

import com.zee.zee5app.exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data

public class Series {
	private String series_id;
	private String series_name;
	private String series_category;
	private String series_release_date;
	private int series_seasons;
	private int series_total_episodes;
	private String series_language;
	private String series_hero;
	@Setter(value = AccessLevel.NONE)
	private String series_location;
	
	private Series() {
		System.out.println("done");
	}

	public void setSeries_location(String series_location) throws LocationNotFoundException {
		if(series_location.length() < 5) {
			throw new LocationNotFoundException("the location is not specified");
		}
		this.series_location = series_location;
	}

}