package com.zee.zee5app.repository.impl;

import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.SeriesRepository;

public class SeriesRepositoryImpl implements SeriesRepository {
	private static SeriesRepository repository;
	public static SeriesRepository getInstance() {
		if(repository==null) {
			repository = new SeriesRepositoryImpl();
		}
		return repository;
	}
	private TreeSet<Series> seriess = new TreeSet();
	private static int count = -1;

	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		boolean result= this.seriess.add(series);
		if (result==true) {
			return "Successfully added series";
		}
		return "Failed to add series";
	}

	@Override
	public String updateSeries(String id, Series series1) {
		// TODO Auto-generated method stub
		/*
		int count1 = 0;
		for (Series series : seriess) {
			if(series != null && series.getSeriesId().equals(id)) {
				seriess[count1] = series1;
				return("Completed");
			}
			count1++;
			
		}
		return("Not Completed");
		*/
		return null;
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Series series2 = null;
		for (Series series : seriess) {
			if(series.getSeriesId().equals(id)) {
				series2 = series;
				break;
				//return Optional.of(register);			
			}
		}
		return Optional.of(Optional.ofNullable(series2).orElseThrow(() -> new IdNotFoundException("ID not found")));
	}

	@Override
	public Series[] getAllSeriess() {
		// TODO Auto-generated method stub
		Series series[]= new Series[seriess.size()];
		
		return seriess.toArray(series);
	}

	@Override
	public String deleteSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Series> optional = this.getSeriesById(id);
		if(optional.isPresent()) {
			//removal
			boolean result = seriess.remove(optional.get());
			if (result) {
				return "Successfully deleted series";
				
			}
			else {
				return "Failed to delete series";
			}
		}
		
		return("Fail");
	}
	

}