package com.acme.edu.implementations.messages;

import com.acme.edu.interfaces.Formatter;
import com.acme.edu.interfaces.Saver;

public class IntMessage extends NumericMessage {
	
	public IntMessage(String value, Formatter formatter, Saver saver) {
		super ( value, formatter, saver );
	}
	
	@Override
	public void getMessage() {
		saver.print ( formatter.formatInt ( message ) + getOverFlowString () );
	}
	
	@Override
	public void setMessage(MegaMessage lastMessage) {
		if ( lastMessage == null ) {
			return;
		}
		if ( this.isTheSameType ( lastMessage ) ) {
			calculateSum ( lastMessage );
		} else {
			lastMessage.getMessage ();
		}
	}
	
	@Override
	public boolean isTheSameType(MegaMessage anotherMessage) {
		return anotherMessage instanceof IntMessage;
	}
	
	@Override
	public String getOverFlowString() {
		String overFlowString = "";
		for (int i = 0; i < Math.abs ( overFlow ); i++) {
			overFlowString += System.lineSeparator ()
					+ formatter.formatInt ( String.valueOf ( getGuardianValue ( Integer.MAX_VALUE, Integer.MIN_VALUE ) ) );
		}
		return overFlowString;
	}
	
	private void calculateSum(MegaMessage lastMessage) {
		int number = Integer.parseInt ( message );
		int previousSum = Integer.parseInt ( lastMessage.getElementaryMessage () );
		overFlow = lastMessage.getOverFlow ();
		previousSum = (int) isSumOverflow ( number, previousSum, Integer.MAX_VALUE, Integer.MIN_VALUE );
		message = previousSum + "";
	}
}
