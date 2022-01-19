package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;

import lombok.Data;

@Data
public class subRepository {
	private Subscribe[] subscribes = new Subscribe[10];
	private static int count=0;
	
	private subRepository() {
		
	}
	
	//Add new subscription
	public String addSubscription(Subscribe subscribe) {
		if (count==subscribes.length) {
			//array is full or go for dynamic array allocation
			Subscribe temp[] = new Subscribe[subscribes.length * 2];
			System.arraycopy(subscribes, 0, temp, 0, subscribes.length);
			subscribes=temp;
			
			subscribes[count++]= subscribe;
			return "Subscription Added";
			//return "array is full";
		}
		subscribes[count++]= subscribe;
		return "Subscription Added";
	}
	
	//Modify subscription
	public String modifySubscription(String subId, Subscribe subscribe) {
		for (int c=0;c<subscribes.length;c++) {
			if (subscribes[c]!=null && subscribes[c].getSubId().equals(subId)) {
				subscribes[c]=subscribe;
				return "Subscription details modified";
			}
		}
		return "Invalid subscription ID";
	}
	
	//Get subscription by ID
	public Subscribe getSubscribebyID(String subId) {
		for (Subscribe subscribe: subscribes) {
			if (subscribe!=null && subscribe.getSubId().equals(subId)){
				return subscribe;
			}
		}
		return null;
	}
	
	
	private static subRepository subRepo;
	public static subRepository getInstance() {
		if (subRepo==null)
			subRepo = new subRepository();
		return subRepo;
	}
}

