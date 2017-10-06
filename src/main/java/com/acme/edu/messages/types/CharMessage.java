package com.acme.edu.messages.types;

import com.acme.edu.exceptions.DataSaveException;
import com.acme.edu.messages.DataMessage;

public class CharMessage extends DataMessage<Character> {
    public static final String TYPE_PREFIX = "char";

    public CharMessage(Character messageValue) {
        super(messageValue);
    }

    @Override
    protected void processNewMessageInternal() throws DataSaveException {
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
