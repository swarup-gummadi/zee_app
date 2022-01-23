package com.zee.zee5app.dto;

import lombok.Data;

@Data

public class Subscription {
	private String sub_id;
	private String sub_type;
	private String sub_dop;
	private String sub_pack_country;
	private String Sub_payment_mode;
	private String sub_autorenewal;
	private String sub_expiry;
	private String status;
	
	public Subscription() {
		System.out.println("done");
	}
}