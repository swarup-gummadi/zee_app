package com.zee.zee5app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.service.EpisodeService;

//@SpringBootApplication
public class TestEpisodeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(TestEpisodeApplication.class, args);
		
		EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
//		FileUtils fileUtils = applicationContext.getBean(FileUtils.class);
//		String des = "C:\\Users\\rithwik.chithreddy\\Downloads\\episodeStore";
		System.out.println("Add Episode");
		for (int i = 1; i <= 5; i++) {
			Episode episode = new Episode("epi000"+i, "EpisodeName"+i, 20+i, "Link"+i, null, null);
			Series series = new Series();
			series.setId("ser000"+i);
			episode.setSeries(series);
//			episode.setTrailer(des);
//			String src = "C:\\Users\\rithwik.chithreddy\\Downloads\\pushpa trailer.mp4";
//			
//			String result = episodeService.addEpisode(episode);
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
			System.out.println(episodeService.addEpisode(episode) + " " + i);
		}
		System.out.println();
		
		System.out.println("Get Episode by Id");
		System.out.println(episodeService.getEpisodeById("epi0004").get());
		System.out.println();
		
		System.out.println("Get All Episode Details - List");
		episodeService.getAllEpisodeDetails().get().forEach(e->System.out.println(e));
		System.out.println();
		
		System.out.println("Delete Episode by Id");
		try {
			System.out.println(episodeService.deleteEpisode("epi0003"));
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println();
		
		System.out.println("Get All Episode Details - Array");
		for (Episode episode : episodeService.getAllEpisode()) {
			System.out.println(episode);
		}
		System.out.println();
		
		applicationContext.close();
	}

}
