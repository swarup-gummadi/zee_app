package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;

public interface SubscriptionService {
	
	public String addSubscription(Subscription subscription);
	public Optional<Subscription> getSubscriptionById(String id);
	public Subscription[] getAllSubscriptions();
	public String deleteSubscription(String id) throws IdNotFoundException;
	public Optional<List<Subscription>> getAllSubscriptionDetails();

}
