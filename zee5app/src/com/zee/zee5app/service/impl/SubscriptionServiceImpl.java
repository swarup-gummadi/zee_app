package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.repository.impl.SubscriptionRepositoryImpl;
import com.zee.zee5app.service.SubscriptionService;

public class SubscriptionServiceImpl implements SubscriptionService {
	private static SubscriptionService service;
	public static SubscriptionService getInstance() {
		if(service==null) {
			service = new SubscriptionServiceImpl();
		}
		return service;
	}
	
	SubscriptionRepository subscriptionRepository = SubscriptionRepositoryImpl.getInstance();

	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		return subscriptionRepository.addSubscription(subscription);
	}

	@Override
	public String updateSubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return subscriptionRepository.updateSubscription(id, subscription);
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return subscriptionRepository.getSubscriptionById(id);
	}

	@Override
	public List<Subscription> getAllSubscriptions() {
		return subscriptionRepository.getAllSubscriptions();
	}

	@Override
	public String deleteSubscriptionById(String id) {
		// TODO Auto-generated method stub
		return subscriptionRepository.deleteSubscriptionById(id);
	}


}