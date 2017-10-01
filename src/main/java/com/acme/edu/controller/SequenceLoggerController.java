package com.acme.edu.controller;

import com.acme.edu.formatter.MessageFormatter;
import com.acme.edu.messages.Message;
import com.acme.edu.saver.DataSaver;

public class SequenceLoggerController implements LoggerController {
    private Message previousMessage;

    private final MessageFormatter messageFormatter;
    private final DataSaver dataSaver;

    public SequenceLoggerController(MessageFormatter messageFormatter, DataSaver dataSaver) {
        this.messageFormatter = messageFormatter;
        this.dataSaver = dataSaver;
    }

    @Override
    public void logMessage(Message messageToLog) {
        messageToLog.setPreviousMessage(previousMessage);
        messageToLog.setDataSaver(dataSaver);
        messageToLog.setFormatter(messageFormatter);

        messageToLog.process();

        previousMessage = messageToLog;
    }
}
