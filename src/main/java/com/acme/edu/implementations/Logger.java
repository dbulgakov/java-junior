package com.acme.edu.implementations;

import com.acme.edu.implementations.exceptions.LoggerException;
import com.acme.edu.implementations.messages.ByteMessage;
import com.acme.edu.implementations.messages.CharMessage;
import com.acme.edu.implementations.messages.IntMessage;
import com.acme.edu.implementations.messages.StringMessage;
import com.acme.edu.interfaces.Formatter;
import com.acme.edu.interfaces.Saver;

public class Logger {
	
	private static Formatter formatter = new TypedFormatter ();
	public static Saver saver = new ConsoleSaver ();
	private static final LoggerController loggerController = new LoggerController ();
	
	public static void log(int message) throws LoggerException {
		try {
			IntMessage megaMessage = new IntMessage ( String.valueOf ( message ), formatter, saver );
			loggerController.log ( megaMessage );
		} catch (LoggerException e) {
			throw new LoggerException ( e.getMessage (), e );
		}
	}
	
	public static void log(byte message) throws LoggerException {
		try {
			ByteMessage megaMessage = new ByteMessage ( String.valueOf ( message ), formatter, saver );
			loggerController.log ( megaMessage );
		} catch (LoggerException e) {
			throw new LoggerException ( e.getMessage (), e );
		}
	}
	
	public static void log(String message) throws LoggerException {
		try {
			StringMessage megaMessage = new StringMessage ( message, formatter, saver );
			loggerController.log ( megaMessage );
		} catch (LoggerException e) {
			throw new LoggerException ( e.getMessage (), e );
		}
	}
	
	public static void log(char message) throws LoggerException {
		try {
			CharMessage megaMessage = new CharMessage ( String.valueOf ( message ), formatter, saver );
			loggerController.log ( megaMessage );
		} catch (LoggerException e) {
			throw new LoggerException ( e.getMessage (), e );
		}
	}
	
	public static void stopLogging() throws LoggerException {
		try {
			loggerController.stopLogging ();
		} catch (LoggerException e) {
			throw new LoggerException ( e.getMessage (), e );
		}
	}
}
