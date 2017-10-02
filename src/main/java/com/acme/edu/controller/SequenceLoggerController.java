package com.acme.edu.controller;

import com.acme.edu.encoder.StringEncoder;
import com.acme.edu.formatter.StringFormatter;
import com.acme.edu.messages.Message;
import com.acme.edu.saver.DataSaver;

public class SequenceLoggerController implements LoggerController {
    private final StringFormatter stringFormatter;
    private final DataSaver dataSaver;
    private final StringEncoder encoder;
    private Message previousMessage;

    public SequenceLoggerController(StringFormatter stringFormatter, DataSaver dataSaver, StringEncoder encoder) {
        this.stringFormatter = stringFormatter;
        this.dataSaver = dataSaver;
        this.encoder = encoder;
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
