package com.acme.edu.interfaces;

import com.acme.edu.implementations.ByteMessage;
import com.acme.edu.implementations.IntMessage;
import com.acme.edu.implementations.StringMessage;

public interface LoggerOOP {
    void log(IntMessage message);


    void log(ByteMessage message);


    void log(StringMessage message);


    void log(char message);


    void log(String... messages);


    void log(int... messages);


    void log(int[][] ints);


    void stopLogging();

}



