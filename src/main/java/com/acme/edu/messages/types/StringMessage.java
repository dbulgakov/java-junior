package com.acme.edu.messages.types;

import com.acme.edu.exceptions.DataSaveException;
import com.acme.edu.messages.DataMessage;
import com.acme.edu.messages.Message;

public class StringMessage extends DataMessage<String> {
    public static final String TYPE_PREFIX = "string";
    private static final String SEQUENCE_FORMAT = "%s (x%d)";

    private int sequenceCounter;

    public StringMessage(String messageValue) {
        super(messageValue);
    }

    @Override
    protected void processNewMessageInternal() throws DataSaveException {
        if (isPreviousMessageExist()) {
            if (isStringMessageSequence()) {
                sequenceCounter = getStringMessageSequenceLength() + 1;
            } else {
                savePreviousIfExists();
                sequenceCounter = 0;
            }
        }
    }

    @Override
    public String getPrefix() {
        return TYPE_PREFIX;
    }

    private Integer getStringMessageSequenceLength() {
        StringMessage previousMessage = (StringMessage) getPreviousMessage();
        return previousMessage != null ? previousMessage.getSequenceCounter() : 0;
    }

    private boolean isStringMessageSequence() {
        Message previousMessage = getPreviousMessage();
        if (isSameType(previousMessage)) {
            StringMessage previousStringMessage = (StringMessage) getPreviousMessage();
            return previousStringMessage.getMessageValue().equals(getMessageValue());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (sequenceCounter == 0) {
            return getMessageValue();
        } else {
            return String.format(SEQUENCE_FORMAT, getMessageValue(), sequenceCounter + 1);
        }
    }

    public int getSequenceCounter() {
        return sequenceCounter;
    }
}
