package com.acme.edu.implementations;

import com.acme.edu.interfaces.Saver;

public class ConsoleSaver implements Saver {
	
	@Override
	public void print(String message) {
		if ( message == null ) {
			throw new NullPointerException ( "I don't want print null!" );
		}
		System.out.println ( message );
	}
}
