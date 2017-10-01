package com.acme.edu.saver;

public class ConsoleDataSaver implements DataSaver {
    @Override
    public void save(String stringToSave) {
        System.out.println(stringToSave);
    }
}
