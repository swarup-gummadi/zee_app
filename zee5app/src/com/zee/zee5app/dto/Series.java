package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Series {
	private String seriesName;
	private String seriesCategory;
	private String seriesReleaseDate;
	private String seriesTrailer;
	private String seriesLanguage;
	private String seriesCast[];
	private String seriesId;
	private long seriesLength;
}
