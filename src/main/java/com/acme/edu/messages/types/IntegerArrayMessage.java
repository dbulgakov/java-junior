package com.acme.edu.messages.types;

import com.acme.edu.exceptions.DataSaveException;
import com.acme.edu.messages.DataMessage;

import java.util.Arrays;

public class IntegerArrayMessage extends DataMessage<Integer[]> {
    public static final String TYPE_PREFIX = "primitives array";

    private String calculatedValue;

    public IntegerArrayMessage(Integer[] messageValue) {
        super(messageValue);
    }

    @Override
    protected void processNewMessageInternal() throws DataSaveException {
        savePreviousIfExists();
        calculatedValue = Arrays.toString(getMessageValue())
                .replace("[", "{")
                .replace("]", "}");
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
