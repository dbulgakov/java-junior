package com.acme.edu.saver;

import java.io.IOException;

public class ConsoleDataSaver implements DataSaver {
    @Override
    public void save(String stringToSave) throws IOException{
        System.out.println(stringToSave);
    }
}
