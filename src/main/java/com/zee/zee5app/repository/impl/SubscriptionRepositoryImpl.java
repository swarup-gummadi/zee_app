package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepository;

public class SubscriptionRepositoryImpl implements SubscriptionRepository {
	private static SubscriptionRepository repository;
	public static SubscriptionRepository getInstance() {
		if(repository==null) {
			repository = new SubscriptionRepositoryImpl();
		}
		return repository;
	}
	private Subscription[] subscriptions = new Subscription[10];
	private static int count = -1;

	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		if(count == subscriptions.length-1) {
			Subscription temp[] = new Subscription[subscriptions.length*2];
			
			System.arraycopy(subscriptions, 0, temp, 0, subscriptions.length);
			subscriptions = temp;
			subscriptions[++count] = subscription;
			return "array is full";
		}
		subscriptions[++count] = subscription;
		return "success";
	}

	@Override
	public String updateSubscription(String id, Subscription subscription1) {
		// TODO Auto-generated method stub
		int count1 = 0;
		for (Subscription subscription : subscriptions) {
			if(subscription != null && subscription.getSub_id().equals(id)) {
				subscriptions[count1] = subscription1;
				return("Completed");
			}
			count1++;
			
		}
		return("Not Completed");
	}

	@Override
	public Subscription getSubscriptionById(String id) {
		// TODO Auto-generated method stub
		for (Subscription subscription : subscriptions) {
			if(subscription!= null && subscription.getSub_id().equals(id)  ) {
				return( subscription);
			}
		}
		return(null);
	}

	@Override
	public Subscription[] getAllSubscriptions() {
		// TODO Auto-generated method stub
		return subscriptions;
	}

	@Override
	public String deleteSubscriptionById(String id) {
		// TODO Auto-generated method stub
		int count1 = 0;
		for (Subscription subscription : subscriptions) {
			
			if(subscription!= null && subscription.getSub_id().equals(id)  ) {
				System.arraycopy(subscriptions, count1+1, subscriptions, count1, subscriptions.length-count1-1);
				subscriptions[subscriptions.length-1] = null;
				return("Completed");
			}
			count1++;
		}
		
		return("Not Completed");
	}

}