package com.acme.edu.implementations.messages;

import com.acme.edu.interfaces.Formatter;
import com.acme.edu.interfaces.Saver;
import com.acme.edu.interfaces.SimpleMessage;

public abstract class MegaMessage implements SimpleMessage {
	String message;
	String overFlowString;
	int overFlow = 0;
	Formatter formatter;
	Saver saver;
	
	protected MegaMessage(String message, Formatter formatter, Saver saver) {
		if ( message == null ) {
			throw new NullPointerException ( "There is not any message!!" );
		}
		if ( formatter == null ) {
			throw new NullPointerException ( "I can't format by null formatter:(" );
		}
		if ( saver == null ) {
			throw new NullPointerException ( "I don't see any Savers;(" );
		}
		this.message = message;
		this.formatter = formatter;
		this.saver = saver;
	}
	
	protected String getOverFlowString() {
		return overFlowString;
	}
	
	protected String getElementaryMessage() {
		return message;
	}
	
	protected int getOverFlow() {
		return overFlow;
	}
	
}
