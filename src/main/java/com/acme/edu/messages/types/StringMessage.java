package com.acme.edu.messages.types;

import com.acme.edu.messages.DataMessage;
import com.acme.edu.messages.Message;
import com.acme.edu.messages.MessageType;

public class StringMessage extends DataMessage<String> {
    public static final String TYPE_PREFIX = null;
    public static final String SEQUENCE_FORMAT = "%s (x%d)";

    private int sequenceCounter;

    public StringMessage(String messageValue) {
        super(messageValue);
    }

    @Override
    protected void processNewMessageInternal() {
        if (isStringMessageSequence()) {
            sequenceCounter += 1;
        } else {
            sequenceCounter = 0;
        }
    }

    @Override
    public MessageType getType() {
        return MessageType.STRING;
    }

    @Override
    public String getPrefix() {
        return TYPE_PREFIX;
    }

    private boolean isStringMessageSequence() {
        Message previousMessage = getPreviousMessage();
        if (previousMessage != null && previousMessage.getType() == MessageType.STRING) {
            DataMessage previousDataMessage = (DataMessage) previousMessage;
            return previousDataMessage.getMessageValue().equals(getMessageValue());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (sequenceCounter == 0) {
            return getMessageValue();
        } else {
            return String.format(SEQUENCE_FORMAT, getMessageValue(), sequenceCounter);
        }
    }
}
