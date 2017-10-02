package com.acme.edu.messages.types;

import com.acme.edu.messages.DataMessage;

public class BooleanMessage extends DataMessage<Boolean>{
    public static final String TYPE_PREFIX = "primitive";

    public BooleanMessage(Boolean messageValue) {
        super(messageValue);
    }

    @Override
    protected void processNewMessageInternal() {
        savePreviousIfExists();
    }

    @Override
    public String getPrefix() {
        return TYPE_PREFIX;
    }

    @Override
    public String toString() {
        return String.valueOf(getMessageValue());
    }
}
