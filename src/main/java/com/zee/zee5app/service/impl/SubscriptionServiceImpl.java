package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.SubscriptionRepository;
//import com.zee.zee5app.repository.impl.SubscriptionRepositoryImpl;
import com.zee.zee5app.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	//private SubscriptionRepository subscriptionRepository = SubscriptionRepositoryImpl.getInstance();
	private SubscriptionServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	private static SubscriptionService subscriptionService;
	public static SubscriptionService getInstance() throws IOException {
		if(subscriptionService==null)
			subscriptionService = new SubscriptionServiceImpl();
		return subscriptionService;
	}

	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		Subscription subscription2 = subscriptionRepository.save(subscription);
		if (subscription2!=null) {
			return "Success";
		}
		else {
			return "Fail";
		}
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return subscriptionRepository.findById(id);
	}

	@Override
	public Subscription[] getAllSubscriptions() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		List<Subscription> list = subscriptionRepository.findAll();
		Subscription[] array = new Subscription[list.size()];
		return subscriptionRepository.findAll().toArray(array);
	}

	

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Subscription> optional = this.getSubscriptionById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("Subscription not found");
			}
			else {
				subscriptionRepository.deleteById(id);
				return "successfully deleted subscription";
			}
		} catch (IdNotFoundException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Subscription>> getAllSubscriptionDetails() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(subscriptionRepository.findAll());
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}



}