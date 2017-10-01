package com.acme.edu.messages;

public abstract class DataMessage<T> extends Message {

    private T messageValue;

    public DataMessage(T messageValue) {
        this.messageValue = messageValue;
    }

    public T getMessageValue() {
        return messageValue;
    }
}
