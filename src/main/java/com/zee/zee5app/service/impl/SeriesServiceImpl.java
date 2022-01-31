package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.impl.SeriesRepositoryImpl;
import com.zee.zee5app.service.seriesService;

public class SeriesServiceImpl implements seriesService {
	
	private SeriesRepository seriesRepository = SeriesRepositoryImpl.getInstance();
	
	private SeriesServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	private static seriesService seriesService;
	public static seriesService getInstance() throws IOException {
		if(seriesService==null)
			seriesService = new SeriesServiceImpl();
		return seriesService;
	}

	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		return seriesRepository.addSeries(series);
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return seriesRepository.getSeriesById(id);
	}

	@Override
	public Series[] getAllSeries() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return seriesRepository.getAllSeries();
	}

	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.modifySeries(id, series);
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.deleteSeries(id);
	}

	@Override
	public Optional<List<Series>> getAllSeriesDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return seriesRepository.getAllSeriesDetails();
	}

}