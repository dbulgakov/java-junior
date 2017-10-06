package com.acme.edu.saver;

import java.io.IOException;

public interface DataSaver {
    void save(String stringToSave) throws IOException;
}
