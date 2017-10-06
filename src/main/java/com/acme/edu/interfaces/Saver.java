package com.acme.edu.interfaces;

import com.acme.edu.implementations.exceptions.SaverException;

public interface Saver {
	void print(String message) throws SaverException;
}
