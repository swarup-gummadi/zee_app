package com.zee.zee5app.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class LocationNotFoundException extends Exception {

	public LocationNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
