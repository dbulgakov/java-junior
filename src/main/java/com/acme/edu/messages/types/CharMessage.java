package com.acme.edu.messages.types;

import com.acme.edu.messages.DataMessage;
import com.acme.edu.messages.MessageType;

public class CharMessage extends DataMessage<Character> {
    private static final String TYPE_PREFIX = "char";

    public CharMessage(Character messageValue) {
        super(messageValue);
    }

    @Override
    protected void processNewMessageInternal() {
        // nothing done here for this type
    }

    @Override
    public void save() {

    }

    @Override
    public MessageType getType() {
        return MessageType.CHAR;
    }

    @Override
    public String getTypePrefixName() {
        return TYPE_PREFIX;
    }
}
