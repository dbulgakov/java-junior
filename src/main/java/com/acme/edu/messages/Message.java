package com.acme.edu.messages;

import com.acme.edu.encoder.StringEncoder;
import com.acme.edu.exceptions.DataSaveException;
import com.acme.edu.formatter.HasPrefix;
import com.acme.edu.formatter.StringFormatter;
import com.acme.edu.saver.DataSaver;

import java.io.IOException;

public abstract class Message implements HasPrefix {
    private Message previousMessage;

    private StringFormatter stringFormatter;
    private DataSaver dataSaver;
    private StringEncoder encoder;

    public void save() throws DataSaveException {
        if (getDataSaver() == null || getFormatter() == null) {
            throw new IllegalStateException("Saver and formatter are required to be setup!");
        }

        String resultString = getFormatter().format(this);

        if (encoder != null) {
            resultString = getEncoder().encode(resultString);
        }

        try {
            getDataSaver().save(resultString);
        } catch (IOException e) {
            throw new DataSaveException(e);
        }
    }

    public void process() throws DataSaveException {
        processNewMessageInternal();
    }

    protected abstract void processNewMessageInternal() throws DataSaveException;

    // region saver and formatter

    public Message getPreviousMessage() {
        return previousMessage;
    }

    public void setPreviousMessage(Message previousMessage) {
        this.previousMessage = previousMessage;
    }

    public StringFormatter getFormatter() {
        return stringFormatter;
    }

    public void setFormatter(StringFormatter stringFormatter) {
        this.stringFormatter = stringFormatter;
    }

    public DataSaver getDataSaver() {
        return dataSaver;
    }

    public void setDataSaver(DataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    public StringEncoder getEncoder() {
        return encoder;
    }

    public void setEncoder(StringEncoder encoder) {
        this.encoder = encoder;
    }

    // endregion

    protected boolean isPreviousMessageExist() {
        return getPreviousMessage() != null;
    }

    protected boolean isSameType(Message messageToCompare) {
        return this.getClass().isInstance(messageToCompare);
    }

    protected void clearPrevious() {
        setPreviousMessage(null);
    }

    protected void savePreviousIfExists() throws DataSaveException {
        if (isPreviousMessageExist()) {
            getPreviousMessage().save();
            clearPrevious();
        }
    }
}
