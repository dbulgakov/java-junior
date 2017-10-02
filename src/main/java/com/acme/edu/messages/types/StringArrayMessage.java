package com.acme.edu.messages.types;

import com.acme.edu.messages.DataMessage;

import java.util.Arrays;

public class StringArrayMessage extends DataMessage<String[]> {
    public static final String TYPE_PREFIX = null;

    private String calculatedValue;

    public StringArrayMessage(String[] messageValue) {
        super(messageValue);
    }

    @Override
    protected void processNewMessageInternal() {
        savePreviousIfExists();
        calculatedValue = Arrays.toString(getMessageValue())
                .replace(", ", "\n")
                .replace("[", "")
                .replace("]", "");
    }

    @Override
    public String getPrefix() {
        return TYPE_PREFIX;
    }

    @Override
    public String toString() {
        return calculatedValue;
    }
}
