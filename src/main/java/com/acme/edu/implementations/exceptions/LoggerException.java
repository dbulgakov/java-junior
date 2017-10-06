package com.acme.edu.implementations.exceptions;

public class LoggerException extends Exception {
	public LoggerException() {
		super ();
	}
	
	public LoggerException(String message) {
		super ( message );
	}
	
	public LoggerException(String message, Throwable th) {
		super ( message, th );
	}
	
	public LoggerException(Throwable th) {
		super ( th );
	}
}
