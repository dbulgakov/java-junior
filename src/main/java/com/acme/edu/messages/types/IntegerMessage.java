package com.acme.edu.messages.types;

public class IntegerMessage extends NumericMessage<Integer> {
    public IntegerMessage(Integer messageValue) {
        super(messageValue);
    }

    @Override
    long getMaxValue() {
        return Integer.MAX_VALUE;
    }

    @Override
    long getMinValue() {
        return Integer.MIN_VALUE;
    }
}
