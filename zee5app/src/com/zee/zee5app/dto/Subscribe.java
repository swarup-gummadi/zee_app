package com.zee.zee5app.dto;

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
