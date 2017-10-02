package com.acme.edu.messages.types;

import com.acme.edu.messages.DataMessage;

public class ByteMessage extends DataMessage<Byte> {
    public static final String TYPE_PREFIX = "primitive";

    public ByteMessage(Byte messageValue) {
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
