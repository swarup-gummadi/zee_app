package com.zee.zee5app.subscriptions.dto;

import lombok.Data;

@Data

public class Subscribe {
	private String subId;
	private String type;
	private String date;
	private String status;
	private String country;
	private String paymentMethod;

}
