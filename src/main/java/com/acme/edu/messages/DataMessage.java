package com.acme.edu.messages;

import javax.xml.crypto.Data;

public abstract class DataMessage<T> extends Message {

    private T messageValue;
    private DataMessage calculatedValue;

    public DataMessage(T messageValue) {
        this.messageValue = messageValue;
    }

    public T getMessageValue() {
        return messageValue;
    }

    public DataMessage getCalculatedValue() {
        return calculatedValue;
    }

    public void setCalculatedValue(DataMessage calculatedValue) {
        this.calculatedValue = calculatedValue;
    }
}
