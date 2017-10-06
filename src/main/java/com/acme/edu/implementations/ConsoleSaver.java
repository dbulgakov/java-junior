package com.acme.edu.implementations;

import com.acme.edu.interfaces.Saver;

public class ConsoleSaver implements Saver {
	
	@Override
	public void print(String message) {
		
		System.out.println ( message );
	}
}
