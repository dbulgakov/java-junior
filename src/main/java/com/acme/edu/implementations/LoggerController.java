package com.acme.edu.implementations;

import com.acme.edu.implementations.exceptions.LoggerException;
import com.acme.edu.implementations.exceptions.SaverException;
import com.acme.edu.implementations.messages.MegaMessage;

/**
 * Java Coding Style Convention (PDF)
 */
public class LoggerController {
	
	private MegaMessage lastMessage;
	
	
	public void log(MegaMessage message) throws LoggerException {
		try {
			if ( message == null || message.getElementaryMessage () == null )
				throw new IllegalAccessError ( "Message is null" );
			message.setMessage ( lastMessage );
			lastMessage = message;
		} catch (IllegalAccessError e) {
			throw new LoggerException ( e.getMessage (), e );
		} catch (SaverException e) {
			throw new LoggerException ( e.getMessage (), e );
		}
		
	}
	
	public void stopLogging() throws LoggerException {
		try {
			if ( lastMessage != null ) {
				lastMessage.getMessage ();
				lastMessage = null;
			}
		} catch (IllegalAccessError e) {
			throw new LoggerException ( e.getMessage (), e );
		} catch (SaverException e) {
			throw new LoggerException ( e.getMessage (), e );
		}
	}
}