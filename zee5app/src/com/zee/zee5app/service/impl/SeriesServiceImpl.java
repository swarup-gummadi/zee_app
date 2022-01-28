package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.impl.SeriesRepositoryImpl;
import com.zee.zee5app.service.SeriesService;

public class SeriesServiceImpl implements SeriesService {
	private static SeriesService service;
	public static SeriesService getInstance() {
		if(service==null) {
			service = new SeriesServiceImpl();
		}
		return service;
	}
	
	SeriesRepository seriesRepository = SeriesRepositoryImpl.getInstance();

	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		return seriesRepository.addSeries(series);
	}

	@Override
	public String updateSeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.updateSeries(id, series);
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.getSeriesById(id);
	}

	@Override
	public Series[] getAllSeriess() {
		return seriesRepository.getAllSeriess();
	}

	@Override
	public String deleteSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.deleteSeriesById(id);
	}

	@Override
	public List<Series> getAllSeriesDetails() {
		// TODO Auto-generated method stub
		return seriesRepository.getAllSeriesDetails();
	}


}
