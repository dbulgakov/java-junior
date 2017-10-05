package com.acme.edu.implementations;

import com.acme.edu.implementations.messages.ByteMessage;
import com.acme.edu.implementations.messages.CharMessage;
import com.acme.edu.implementations.messages.IntMessage;
import com.acme.edu.implementations.messages.StringMessage;
import com.acme.edu.interfaces.Formatter;
import com.acme.edu.interfaces.Saver;

public class Logger {
	
	private static final Formatter formatter = new TypedFormatter ();
	private static final Saver saver = new ConsoleSaver ();
	private static final LoggerController loggerController = new LoggerController ();
	
	public static void log(int message) {
		IntMessage megaMessage = new IntMessage ( String.valueOf ( message ), formatter, saver );
		loggerController.log ( megaMessage );
	}
	
	public static void log(byte message) {
		ByteMessage megaMessage = new ByteMessage ( String.valueOf ( message ), formatter, saver );
		loggerController.log ( megaMessage );
	}
	
	public static void log(String message) {
		try {
			StringMessage megaMessage = new StringMessage ( message, formatter, saver );
			loggerController.log ( megaMessage );
		} catch (NullPointerException ex) {
			throw new NullPointerException ( ex.getMessage () );
		}
	}
	
	public static void log(char message) {
		CharMessage megaMessage = new CharMessage ( String.valueOf ( message ), formatter, saver );
		loggerController.log ( megaMessage );
	}
	
	public static void stopLogging() {
		loggerController.stopLogging ();
	}
}
