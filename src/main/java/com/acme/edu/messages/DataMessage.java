package com.acme.edu.messages;

public abstract class DataMessage<MSG_TYPE> extends Message {

    private MSG_TYPE messageValue;

    public DataMessage(MSG_TYPE messageValue) {
        this.messageValue = messageValue;
    }

    public MSG_TYPE getMessageValue() {
        return messageValue;
    }
}
