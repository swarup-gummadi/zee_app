package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;

public interface SubscriptionRepository {
	
	public String addSubscription(Subscription subscription);
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException;
	public Subscription[] getAllSubscriptions() throws InvalidIdLengthException;
	public String modifySubscription(String id, Subscription subscription) throws IdNotFoundException;
	public String deleteSubscription(String id) throws IdNotFoundException;
	public Optional<List<Subscription>> getAllSubscriptionDetails() throws InvalidIdLengthException;

}