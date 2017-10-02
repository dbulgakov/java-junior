package com.acme.edu.controller;

import com.acme.edu.formatter.StringFormatter;
import com.acme.edu.messages.Message;
import com.acme.edu.saver.DataSaver;

public class SequenceLoggerController implements LoggerController {
    private Message previousMessage;

    private final StringFormatter stringFormatter;
    private final DataSaver dataSaver;

    public SequenceLoggerController(StringFormatter stringFormatter, DataSaver dataSaver) {
        this.stringFormatter = stringFormatter;
        this.dataSaver = dataSaver;
    }

    @Override
    public void logMessage(Message messageToLog) {
        messageToLog.setPreviousMessage(previousMessage);
        messageToLog.setDataSaver(dataSaver);
        messageToLog.setFormatter(stringFormatter);

        messageToLog.process();

        previousMessage = messageToLog;
    }
}
