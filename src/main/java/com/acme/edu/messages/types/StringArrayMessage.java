package com.acme.edu.messages.types;

import com.acme.edu.messages.DataMessage;
import com.acme.edu.messages.MessageType;

import java.util.Arrays;

public class StringArrayMessage extends DataMessage<String[]> {
    private static final String TYPE_PREFIX = "";

    private String calculatedValue;

    public StringArrayMessage(String[] messageValue) {
        super(messageValue);
    }

    @Override
    protected void processNewMessageInternal() {
        calculatedValue = Arrays.toString(getMessageValue())
                .replace(", ", "\n")
                .replace("[", "")
                .replace("]", "");
    }

    @Override
    public void save() {

    }

    @Override
    public MessageType getType() {
        return MessageType.STRING_ARRAY;
    }

    @Override
    public String getTypePrefixName() {
        return TYPE_PREFIX;
    }
}
