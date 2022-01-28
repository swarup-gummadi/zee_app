package com.zee.zee5app.service;

import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;

public interface seriesService {
	public String addSeries(Series series);
	public String updateSeries(String id, Series series);
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException;
	public Series[] getAllSeriess();
	public String deleteSeriesById(String id) throws IdNotFoundException;
}
