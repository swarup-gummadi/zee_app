package com.zee.zee5app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.service.SeriesService;

//@SpringBootApplication
public class TestSeriesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(TestSeriesApplication.class, args);
		
		SeriesService seriesService = applicationContext.getBean(SeriesService.class);
//		FileUtils fileUtils = applicationContext.getBean(FileUtils.class);
//		String des = "C:\\Users\\rithwik.chithreddy\\Downloads\\seriesStore";
		System.out.println("Add Series");
		for (int i = 1; i <= 5; i++) {
			Series series = new Series("ser000"+i, "SeriesName"+i, 5+i, null, "Cast"+i, "Genre"+i, "2022-04-0"+i, "Language"+i, 18+i, null);
//			series.setTrailer(des);
//			String src = "C:\\Users\\rithwik.chithreddy\\Downloads\\pushpa trailer.mp4";
//			
//			String result = seriesService.addSeries(series);
//			if (result.equals("Success")) {
//				File file = new File(src);
//				byte[] data = null;
//				try {
//					data = fileUtils.readFile(file);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				fileUtils.writeFile(data, des + file.getName());
//			}
			System.out.println(seriesService.addSeries(series) + " " + i);
		}
		System.out.println();
		
		System.out.println("Get Series by Id");
		System.out.println(seriesService.getSeriesById("ser0004").get());
		System.out.println();
		
		System.out.println("Get All Series Details - List");
		seriesService.getAllSeriesDetails().get().forEach(e->System.out.println(e));
		System.out.println();
		
		System.out.println("Delete Series by Id");
		try {
			System.out.println(seriesService.deleteSeries("ser0003"));
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println();
		
		System.out.println("Get All Series Details - Array");
		for (Series series : seriesService.getAllSeries()) {
			System.out.println(series);
		}
		System.out.println();
		
		applicationContext.close();
	}

}
