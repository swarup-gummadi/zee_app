package com.zee.zee5app.subscriptions.service;

import com.zee.zee5app.subscriptions.dto.Subscribe;
import com.zee.zee5app.subscriptions.repository.subRepository;

import lombok.Data;

@Data
public class subService {
	private subRepository repository= subRepository.getInstance();
	
private static subService service= null;
	
	public static subService getInstance() {
		if (service==null)
		service = new subService();
		return service;
	}
	
	public String addSubscription(Subscribe subscribe) {
		return this.repository.addSubscription(subscribe);
		
	}
	public Subscribe getSubById(String id) {
		return repository.getSubscribebyID(id);
	}
	
	/*
	 * public Register[] getAllUsers() { return repository.getUsers(); }
	 */
	
	public String modifySub(String id, Subscribe subscribe) {
		return repository.modifySubscription(id, subscribe);
	}
}
