package com.acme.edu.messages.types;

import com.acme.edu.exceptions.DataSaveException;
import com.acme.edu.messages.Message;

public class StopMessage extends Message {
    public static final String TYPE_PREFIX = "stop message";

    @Override
    protected void processNewMessageInternal() throws DataSaveException{
        if (isPreviousMessageExist() && isSameType(getPreviousMessage())) {
            throw new IllegalStateException("Already stopped!");
        } else {
            savePreviousIfExists();
        }
    }

    @Override
    public String getPrefix() {
        return TYPE_PREFIX;
    }

    @Override
    public void save() {
        // stop message is not saved anywhere
    }
}
