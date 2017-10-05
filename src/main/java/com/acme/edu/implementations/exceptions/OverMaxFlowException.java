package com.acme.edu.implementations.exceptions;

public class OverMaxFlowException extends Exception {
	private String message = "You are upper, than max value!";
	
	@Override
	public String getMessage() {
		return message;
	}
}

