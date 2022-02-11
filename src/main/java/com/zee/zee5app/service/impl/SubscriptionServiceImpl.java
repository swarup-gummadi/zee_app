package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		Subscription subscription2 = subscriptionRepository.save(subscription);
		if (subscription2!=null)
			return "Success";
		else
			return "Fail";
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) {
		// TODO Auto-generated method stub
		return subscriptionRepository.findById(id);
	}

	@Override
	public Subscription[] getAllSubscriptions() {
		// TODO Auto-generated method stub
		List<Subscription> list = subscriptionRepository.findAll();
		Subscription[] subscriptions = new Subscription[list.size()];
		return list.toArray(subscriptions);
	}

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Subscription> optional = this.getSubscriptionById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException("Record not found");
		else {
			subscriptionRepository.deleteById(id);
			return "Success";
		}
	}

	@Override
	public Optional<List<Subscription>> getAllSubscriptionDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(subscriptionRepository.findAll());
	}

}
