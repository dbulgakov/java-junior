package com.acme.edu.interfaces;

import com.acme.edu.implementations.messages.ByteMessage;
import com.acme.edu.implementations.messages.CharMessage;
import com.acme.edu.implementations.messages.IntMessage;
import com.acme.edu.implementations.messages.StringMessage;

public interface LoggerOOP {
    void log(IntMessage message);


    void log(ByteMessage message);


    void log(StringMessage message);


    void log(CharMessage message);


    void log(String... messages);


    void log(int... messages);


    void log(int[][] ints);


    void stopLogging();

}



