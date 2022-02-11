package com.zee.zee5app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.service.SubscriptionService;

//@SpringBootApplication
public class TestSubscriptionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(TestSubscriptionApplication.class, args);
		
		SubscriptionService subscriptionService = applicationContext.getBean(SubscriptionService.class);
		System.out.println("Add Subscription");
		for (int i = 1; i <= 5; i++) {
			Subscription subscription = new Subscription("sub000"+i, "2022-03-0"+i, "2023-03-0"+i, 2000+i, "credit"+i, "yearly"+i, "active"+i, "true"+i, null);
			User register = new User();
			register.setId("reg000"+i);
			subscription.setRegister(register);
			System.out.println(subscriptionService.addSubscription(subscription) + " " + i);
		}
		System.out.println();
		
//		System.out.println("Get Subscription by Id");
//		System.out.println(subscriptionService.getSubscriptionById("sub0004").get());
//		System.out.println();
//		
//		System.out.println("Get All Subscription Details - List");
//		subscriptionService.getAllSubscriptionDetails().get().forEach(e->System.out.println(e));
//		System.out.println();
//		
//		System.out.println("Delete Subscription by Id");
//		try {
//			System.out.println(subscriptionService.deleteSubscription("sub0003"));
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println();
//		
//		System.out.println("Get All Subscription Details - Array");
//		for (Subscription subscription : subscriptionService.getAllSubscriptions()) {
//			System.out.println(subscription);
//		}
//		System.out.println();
		
		applicationContext.close();
	}

}
