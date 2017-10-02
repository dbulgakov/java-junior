package com.acme.edu.messages.types;

public class ByteMessage extends NumericMessage<Byte> {
    public ByteMessage(Byte messageValue) {
        super(messageValue);
    }

    @Override
    long getMaxValue() {
        return Byte.MAX_VALUE;
    }

    @Override
    long getMinValue() {
        return Byte.MIN_VALUE;
    }
}
