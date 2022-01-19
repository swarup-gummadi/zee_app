package com.zee.zee5app.service;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.seriesRepo;

public class seriesService {
	seriesRepo seriesrepo=seriesRepo.getInstance();
	private seriesService() {
		// TODO Auto-generated constructor stub
	}
	private static seriesService seriesservice=null;
	public static seriesService getInstance()
	{
		if(seriesservice==null)
			seriesservice=new seriesService();
		return seriesservice;
	}
	public String addSeries(Series serie)
	{
		return this.seriesrepo.addSeries(serie);
	}
	public Series getSeriesById(String id)
	{
		return this.seriesrepo.getSeriesById(id);
	}
	public Series[] getAllUsers()
	{
		return this.seriesrepo.getSeries();
	}
	public String modifySeries(String id,Series serie)
	{
		return this.seriesrepo.modifySeries(id, serie);
	}
}
