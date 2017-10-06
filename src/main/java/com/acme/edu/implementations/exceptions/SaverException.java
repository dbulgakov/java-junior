package com.acme.edu.implementations.exceptions;


public class SaverException extends Exception {
	
	public SaverException() {
		super ();
	}
	
	public SaverException(String message) {
		super ( message );
	}
	
	public SaverException(String message, Throwable th) {
		super ( message, th );
	}
	
	public SaverException(Throwable th) {
		super ( th );
	}
	
}
