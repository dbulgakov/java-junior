package com.acme.edu.messages.types;

import com.acme.edu.messages.DataMessage;
import com.acme.edu.messages.MessageType;

public class IntegerMessage extends DataMessage<Integer>{
    public static final String TYPE_PREFIX = "primitive";

    public IntegerMessage(Integer messageValue) {
        super(messageValue);
    }

    @Override
    protected void processNewMessageInternal() {

    }

    @Override
    public MessageType getType() {
        return MessageType.INTEGER;
    }

    @Override
    public String getPrefix() {
        return TYPE_PREFIX;
    }
}
