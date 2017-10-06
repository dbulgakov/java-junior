package com.acme.edu.interfaces;


import com.acme.edu.implementations.exceptions.SaverException;
import com.acme.edu.implementations.messages.MegaMessage;

public interface SimpleMessage {
	
	void getMessage() throws SaverException;
	
	void setMessage(MegaMessage lastMessage) throws SaverException;
	
	String getElementaryMessage();
	
	boolean isTheSameType(MegaMessage anotherMessage);
	
}
