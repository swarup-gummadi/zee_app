package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Movies {
	private String movieName;
	private String movieCategory;
	private String movieReleaseDate;
	private String movieTrailer;
	private String movieLanguage;
	private String movieCast[];
	private String movieId;
	private long movieLength;
}
