package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.SubscriptionRepository;

public class SubscriptionRepositoryImpl implements SubscriptionRepository {
private SubscriptionRepositoryImpl() {
		
	}
	private static SubscriptionRepository repository;
	public static SubscriptionRepository getInstance() {
		if(repository==null) {
			repository = new SubscriptionRepositoryImpl();
		}
		return repository;
	}
	
	private ArrayList<Subscription> arraylist = new ArrayList<>();

	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		boolean result = this.arraylist.add(subscription);
		if(result) {
			
		
		return "success";}
		
	else {
		return "fail";
	}
		}

	@Override
	public String updateSubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Subscription subscription2 = null;
		for (Subscription subscription : arraylist) {
			if(subscription!=null && subscription.getSub_id().equals(id)) {
				subscription2 = subscription ;
			}
			
		}
		return Optional.ofNullable(Optional.of(subscription2).orElseThrow(()-> new IdNotFoundException("id not found")));
//		if subscription is holding null it will act like empty
//		if subscription is holding object if will act like of
	}

	@Override
	public List<Subscription> getAllSubscriptions() {
		// TODO Auto-generated method stub
		return arraylist;
		
		
	}

	@Override
	public String deleteSubscriptionById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}