package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.service.SeriesService;

@Service
public class SeriesServiceImpl implements SeriesService {
	
	@Autowired
	private SeriesRepository seriesRepository;

	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		Series series2 = seriesRepository.save(series);
		if (series2!=null)
			return "Success";
		else
			return "Fail";
	}

	@Override
	public Optional<Series> getSeriesById(String id) {
		// TODO Auto-generated method stub
		return seriesRepository.findById(id);
	}

	@Override
	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		List<Series> list = seriesRepository.findAll();
		Series[] series = new Series[list.size()];
		return list.toArray(series);
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Series> optional = this.getSeriesById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException("Record not found");
		else {
			seriesRepository.deleteById(id);
			return "Success";
		}
	}

	@Override
	public Optional<List<Series>> getAllSeriesDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(seriesRepository.findAll());
	}

}
