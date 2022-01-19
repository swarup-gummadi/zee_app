package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Series;

public class seriesRepo {
	private Series  [] series=new Series[1000];
	private static int count=0;
	
	public Series[] getSeries()
	{
		return series;
	}
	
	public String addSeries(Series serie)
	{
		if(count==series.length)
		{
			Series temp[]=new Series[series.length*2];
			System.arraycopy(series, 0, temp, 0, series.length);
			series=temp;
		}
		series[count++]=serie;
		return "success";
	}
	
	public Series getSeriesById(String serieId)
	{
		for (Series serie : series) {
			if(serie!=null && serie.getSeriesId().equals(serieId))
				return serie;
		}
		return null;
	}
	
	public String modifySeries(String serieId,Series serie)
	{
		for(Series serie1:series)
		{
			if(serie1!=null && serie1.getSeriesId().equals(serieId))
			{
				serie1=serie;
				return "success";
			}
		}
		return "id does not exist";
	}
	private static seriesRepo repo;
	public static seriesRepo getInstance()
	{
		if(repo==null)
			repo=new seriesRepo();
		return repo;
	}
}
