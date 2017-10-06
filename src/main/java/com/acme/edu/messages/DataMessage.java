package com.acme.edu.messages;

import com.acme.edu.exceptions.DataSaveException;

public abstract class DataMessage<T> extends Message {

    private T messageValue;

    public DataMessage(T messageValue) {
        this.messageValue = messageValue;
    }

    public T getMessageValue() {
        return messageValue;
    }

    @Override
    public void process() throws DataSaveException {
        if (getMessageValue() == null) throw new IllegalArgumentException();
        super.process();
    }
}
