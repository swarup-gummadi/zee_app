package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.SeriesRepository;
//import com.zee.zee5app.repository.impl.SeriesRepositoryImpl;
import com.zee.zee5app.service.seriesService;

@Service
public class SeriesServiceImpl implements seriesService {
	@Autowired
	private SeriesRepository seriesRepository;
	//private SeriesRepository seriesRepository = SeriesRepositoryImpl.getInstance();
	
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
		Series series2 =seriesRepository.save(series);
		if (series2!=null) {
			return "success";
		}
		else {
			return "fail";
		}
		
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return seriesRepository.findById(id);
	}

	@Override
	public Series[] getAllSeries() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		List<Series> list = seriesRepository.findAll();
		Series[] array = new Series[list.size()];
		return seriesRepository.findAll().toArray(array);
	}

	

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Series> optional = this.getSeriesById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("Series not found");
			}
			else {
				seriesRepository.deleteById(id);
				return "successfully deleted series";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Series>> getAllSeriesDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(seriesRepository.findAll());
	}

	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}