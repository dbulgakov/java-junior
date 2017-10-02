package com.acme.edu.messages.types;

import com.acme.edu.messages.Message;

public class StopMessage extends Message {
    public static final String TYPE_PREFIX = "stop message";

    @Override
    protected void processNewMessageInternal() {
        if (isPreviousMessageExist() && isSameType(getPreviousMessage())) {
            throw new IllegalStateException("Already stopped!");
        } else {
            getPreviousMessage().save();
        }
    }

    @Override
    public String getPrefix() {
        return TYPE_PREFIX;
    }
}
