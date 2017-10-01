package com.acme.edu.messages.types;

import com.acme.edu.messages.DataMessage;
import com.acme.edu.messages.MessageType;

import java.util.Arrays;

public class IntegerArrayMessage extends DataMessage<Integer[]> {
    private static final String TYPE_PREFIX = "primitives array";

    private String calculatedValue;

    public IntegerArrayMessage(Integer[] messageValue) {
        super(messageValue);
    }

    @Override
    protected void processNewMessageInternal() {
        calculatedValue = Arrays.toString(getMessageValue())
                .replace("[", "{")
                .replace("]", "}");
    }

    @Override
    public MessageType getType() {
        return MessageType.INTEGER_ARRAY;
    }

    @Override
    public String getPrefix() {
        return TYPE_PREFIX;
    }
}
