package com.acme.edu.messages.types;

import com.acme.edu.messages.DataMessage;

import java.util.Arrays;

public class IntegerMatrixMessage extends DataMessage<Integer[][]> {
    public static final String TYPE_PREFIX = "primitives matrix";
    private static final String MATRIX_FORMAT = "{\n%s}";

    private String calculatedValue;

    public IntegerMatrixMessage(Integer[][] messageValue) {
        super(messageValue);
    }

    @Override
    protected void processNewMessageInternal() {
        savePreviousIfExists();

        StringBuilder sb = new StringBuilder();

        for (Integer[] innerArray : getMessageValue()) {
            sb.append(String.format("%s\n", getFormattedArrayString(innerArray)));
        }

        calculatedValue = sb.toString();
    }

    @Override
    public String getPrefix() {
        return TYPE_PREFIX;
    }

    @Override
    public String toString() {
        return String.format(MATRIX_FORMAT, calculatedValue);
    }

    private String getFormattedArrayString(Integer[] array) {
        return Arrays.toString(array)
                .replace("[", "{")
                .replace("]", "}");
    }
}
