package com.acme.edu.saver;

import java.io.IOException;

public class ThrowDataSaver implements DataSaver {
    @Override
    public void save(String stringToSave) throws IOException {
        throw new IOException("dummy IO exception");
    }
}
