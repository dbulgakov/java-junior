package com.acme.edu.implementations.messages;

import com.acme.edu.interfaces.Formatter;
import com.acme.edu.interfaces.Saver;

public class CharMessage extends MegaMessage {
	
	public CharMessage(String message, Formatter formatter, Saver saver) {
		super ( message, formatter, saver );
	}
	
	
	@Override
	public void getMessage() {
		saver.print ( overFlowString );
	}
	
	@Override
	public void setMessage(MegaMessage megaMessage) {
		if ( megaMessage != null ) {
			overFlowString += System.lineSeparator () + megaMessage.getOverFlowString ();
		}
		overFlowString += formatter.formatChar ( message );
	}
	
	@Override
	public boolean isTheSameType(MegaMessage anotherMessage) {
		return anotherMessage instanceof CharMessage;
	}
}
