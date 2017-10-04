package com.acme.edu.implementations;

import com.acme.edu.implementations.messages.*;
import com.acme.edu.interfaces.Saver;

import java.util.Arrays;

/**
 * Java Coding Style Convention (PDF)
 */
public class LoggerController {

    private MegaMessage lastMessage;


    public void log(MegaMessage message) {
        message.setMessage(lastMessage);
        lastMessage = message;
    }

    public void stopLogging() {
        if (lastMessage != null) {
            lastMessage.getMessage();
            lastMessage = null;
        }
    }
}

class Main {
    public static void main(String[] args) {
        //region when
        Logger.log((byte)10);
        Logger.log((byte)10);
        Logger.log(10);
        Logger.stopLogging();
        //endregion
    }
}
