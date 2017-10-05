package com.acme.edu.implementations.exceptions;

public class OverMinFlowException extends Exception {
	private String message = "You are lower, than min value!";
	
	@Override
	public String getMessage() {
		return message;
	}
}
