package com.acme.edu.implementations;

import com.acme.edu.implementations.exceptions.SaverException;
import com.acme.edu.interfaces.Saver;

public class FakeSaver implements Saver {
	@Override
	public void print(String message) throws SaverException {
		throw new SaverException ( "Saver exception!!" );
	}
}
