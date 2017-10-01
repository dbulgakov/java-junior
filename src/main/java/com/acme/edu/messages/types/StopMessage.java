package com.acme.edu.messages.types;

import com.acme.edu.messages.Message;
import com.acme.edu.messages.MessageType;

public class StopMessage extends Message {
    private static final String TYPE_PREFIX = "stop message";

    @Override
    protected void processNewMessageInternal() {

    }

    @Override
    public void save() {

    }

    @Override
    public MessageType getType() {
        return MessageType.STOP;
    }

    @Override
    public String getTypePrefixName() {
        return TYPE_PREFIX;
    }
}
