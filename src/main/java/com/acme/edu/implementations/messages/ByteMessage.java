package com.acme.edu.implementations.messages;

import com.acme.edu.interfaces.Formatter;
import com.acme.edu.interfaces.Saver;

public class ByteMessage extends NumericMessage {
	
	public ByteMessage(String message, Formatter formatter, Saver saver) {
		super ( message, formatter, saver );
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
		
		return anotherMessage instanceof ByteMessage;
	}
	
	@Override
	public String getOverFlowString() {
		String overFlowString = "";
		for (int i = 0; i < Math.abs ( overFlow ); i++) {
			overFlowString += System.lineSeparator ()
					+ formatter.formatInt ( String.valueOf ( getGuardianValue ( Byte.MAX_VALUE, Byte.MIN_VALUE ) ) );
		}
		return overFlowString;
	}
	
	private void calculateSum(MegaMessage lastMessage) {
		byte number = Byte.parseByte ( message );
		int previousSum = Byte.parseByte ( lastMessage.getElementaryMessage () );
		overFlow = lastMessage.getOverFlow ();
		previousSum = (byte) isSumOverflow ( number, previousSum, Byte.MAX_VALUE, Byte.MIN_VALUE );
		message = previousSum + "";
	}
	
}
