package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;

public interface SubscriptionService {
	
	public String addSubscription(Subscription subscription);
	public String updateSubscription(String id, Subscription subscription);
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException;
	public List<Subscription> getAllSubscriptions();
	public String deleteSubscriptionById(String id);



}