package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;

public interface SubscriptionRepository {
	public String addSubscription(Subscription subscription);
	public String updateSubscription(String id, Subscription subscription);
	public Subscription getSubscriptionById(String id);
	public Subscription[] getAllSubscriptions();
	public String deleteSubscriptionById(String id);



}