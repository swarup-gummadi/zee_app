package com.zee.zee5app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(Zee5appspringbootApplication.class, args);
		
//		RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
//		UserService userService = applicationContext.getBean(UserService.class);
//		
//		Register register = new Register("reg0006", "Rithwik6", "Chithreddy6", "rithwik6@gmail.com", "rith1236", new BigInteger("9321654876"), null);
//		Set<Role> roles = new HashSet<Role>();
//		roles.add(roleRepository.findById(1).get());
//		roles.add(roleRepository.findById(2).get());
//		register.setRoles(roles);
//		System.out.println(userService.addUser(register));
//		System.out.println();
		
//		SeriesService seriesService = applicationContext.getBean(SeriesService.class);
//		Series series = new Series("ser0001", "SeriesName1", 6, null, "Cast1", "Genre1", "2022-04-01", "Language1", 19, null);
//		Series series2 = new Series("ser0002", "SeriesName2", 7, null, "Cast2", "Genre2", "2022-04-02", "Language2", 20, null);
//		System.out.println(seriesService.addSeries(series));
//		System.out.println(seriesService.addSeries(series2));
//		Episode episode = new Episode("epi0001", "EpisodeName1", 20, "Link1", null, series);
//		EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
//		System.out.println(episodeService.addEpisode(episode));
		
//		SubscriptionService subscriptionService = applicationContext.getBean(SubscriptionService.class);
//		Subscription subscription = new Subscription("sub0001", "2022-03-01", "2023-03-01", 2001, "credit1", "yearly1", "active1", "true1", null);
//		Register register = new Register();
//		register.setId("reg0001");
//		subscription.setRegister(register);
//		System.out.println(subscriptionService.addSubscription(subscription));
//		Subscription subscription2 = new Subscription("sub0002", "2022-03-02", "2023-03-02", 2002, "credit2", "yearly2", "active2", "true2", null);
//		Register register2 = new Register();
//		register.setId("reg0001");
//		subscription.setRegister(register2);
//		System.out.println(subscriptionService.addSubscription(subscription2));
		
//		MovieService movieService = applicationContext.getBean(MovieService.class);
//		FileUtils fileUtils = applicationContext.getBean(FileUtils.class);
//		String src = "C:\\Users\\rithwik.chithreddy\\Downloads\\pushpa trailer.mp4";
//		String des = "C:\\Users\\rithwik.chithreddy\\Downloads\\movieStore\\";
//		
//		Movie movie = new Movie("mov0001", "Pushpa", 18, "Allu Arjun", "Action", 250, null, "2022-12-15", "Hindi");
//		movie.setTrailer(des);
//		
//		String result = movieService.addMovie(movie);
//		if (result.equals("Success")) {
//			File file = new File(src);
//			byte[] data = null;
//			try {
//				data = fileUtils.readFile(file);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			fileUtils.writeFile(data, des + file.getName());
//		}
		
//		applicationContext.close();
	}

}
