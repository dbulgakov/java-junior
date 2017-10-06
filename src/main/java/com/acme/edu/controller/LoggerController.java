package com.acme.edu.controller;

import com.acme.edu.exceptions.IllegalMessageException;
import com.acme.edu.messages.Message;

public interface LoggerController {
    void logMessage(Message messageToLog) throws IllegalMessageException;
}
