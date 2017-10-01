package com.acme.edu.messages.types;

import com.acme.edu.messages.DataMessage;
import com.acme.edu.messages.MessageType;

public class IntegerMatrixMessage extends DataMessage<Integer[][]> {
    public static final String TYPE_PREFIX = "primitives matrix";

    private String calculatedValue;

    public IntegerMatrixMessage(Integer[][] messageValue) {
        super(messageValue);
    }

    @Override
    protected void processNewMessageInternal() {
        StringBuilder sb = new StringBuilder();

        for (Integer[] innerArray : getMessageValue()) {
//            sb.append(String.format("%s\n", getFromattedArrayString(innerArray)));
        }

        calculatedValue =  sb.toString();
    }

    @Override
    public MessageType getType() {
        return MessageType.INTEGER_MATRIX;
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
