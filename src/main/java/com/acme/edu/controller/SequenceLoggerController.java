package com.acme.edu.controller;

import com.acme.edu.encoder.StringEncoder;
import com.acme.edu.exceptions.DataSaveException;
import com.acme.edu.exceptions.IllegalMessageException;
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
    public void logMessage(Message messageToLog) throws IllegalMessageException {
        try {

            if (messageToLog == null) throw new IllegalArgumentException("Null message passed!");

            messageToLog.setPreviousMessage(previousMessage);
            messageToLog.setDataSaver(dataSaver);
            messageToLog.setFormatter(stringFormatter);
            messageToLog.setEncoder(encoder);
            messageToLog.process();
        } catch (IllegalArgumentException e) {
            throw new IllegalMessageException("Illegal message passed as argument", e);
        } catch (DataSaveException | IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("UNHANDLED ERROR OCCURED");
            e.printStackTrace();
        }

        previousMessage = messageToLog;
    }
}
