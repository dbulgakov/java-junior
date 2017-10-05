package com.acme.edu.implementations;

import com.acme.edu.implementations.messages.MegaMessage;

/**
 * Java Coding Style Convention (PDF)
 */
public class LoggerController {
	
	private MegaMessage lastMessage;
	
	
	public void log(MegaMessage message) {
		message.setMessage ( lastMessage );
		lastMessage = message;
	}
	
	public void stopLogging() {
		if ( lastMessage != null ) {
			lastMessage.getMessage ();
			lastMessage = null;
		}
	}
}