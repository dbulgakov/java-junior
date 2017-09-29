package com.acme.edu.implementations;

import com.acme.edu.interfaces.Printer;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
