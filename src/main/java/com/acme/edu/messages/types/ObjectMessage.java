package com.acme.edu.messages.types;

import com.acme.edu.messages.DataMessage;

public class ObjectMessage extends DataMessage<Object> {
    public static final String TYPE_PREFIX = "reference";

    public ObjectMessage(Object messageValue) {
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
}
