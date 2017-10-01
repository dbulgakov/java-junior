package com.acme.edu.messages.types;

import com.acme.edu.messages.Message;
import com.acme.edu.messages.MessageType;

public class StopMessage extends Message {
    public static final String TYPE_PREFIX = "stop message";

    @Override
    protected void processNewMessageInternal() {
        if (getPreviousMessage().getType() == MessageType.STOP) {
            throw new IllegalStateException("Already stopped!");
        } else {
            getPreviousMessage().save();
        }
    }

    @Override
    public MessageType getType() {
        return MessageType.STOP;
    }

    @Override
    public String getPrefix() {
        return TYPE_PREFIX;
    }
}
