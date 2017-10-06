package com.acme.edu.messages;

import com.acme.edu.exceptions.DataSaveException;

public abstract class DataMessage<MSG_TYPE> extends Message {

    private MSG_TYPE messageValue;

    public DataMessage(MSG_TYPE messageValue) {
        this.messageValue = messageValue;
    }

    public MSG_TYPE getMessageValue() {
        return messageValue;
    }

    @Override
    public void process() throws DataSaveException {
        if (getMessageValue() == null) throw new IllegalArgumentException();
        super.process();
    }
}
