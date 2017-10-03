package com.acme.edu.implementations;

import com.acme.edu.implementations.messages.*;
import com.acme.edu.interfaces.Saver;

import java.util.Arrays;

/**
 * Java Coding Style Convention (PDF)
 */
public class LoggerController {

    private MegaMessage lastMessage;
    private final Saver saver;

    LoggerController(Saver saver) {
        this.saver = saver;
    }


    public void log(MegaMessage message) {
        if (!message.isTheSameType(lastMessage)) {
            saver.print(lastMessage.getMessage());
            lastMessage = null;
        } else {
            message.setMessage(lastMessage);
        }
        lastMessage = message;
    }

    public void stopLogging() {
        if (lastMessage != null) {
            saver.print(lastMessage.getMessage());
            lastMessage = null;
        }
    }
}

class Main {
    public static void main(String[] args) {
        //region when
        //region when
        Logger.log('a');
        Logger.log('b');
        Logger.stopLogging();
        //endregion
    }
}
