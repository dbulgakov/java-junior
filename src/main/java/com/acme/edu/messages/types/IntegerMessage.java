package com.acme.edu.messages.types;

import com.acme.edu.messages.DataMessage;
import com.acme.edu.messages.Message;
import com.acme.edu.messages.MessageType;

public class IntegerMessage extends DataMessage<Integer> {
    public static final String TYPE_PREFIX = "primitive";

    private Integer calculatedSum;
    private boolean isSumOverflow;

    public IntegerMessage(Integer messageValue) {
        super(messageValue);
    }

    @Override
    protected void processNewMessageInternal() {
        Message previousMessage = getPreviousMessage();
        if (isPreviousMessageExist()) {
            if (previousMessage.getType() == MessageType.INTEGER) {
                calculatedSum = getCalculatedSum(previousMessage);
                setCalculatedValue(new IntegerMessage(calculatedSum));
            } else {
                previousMessage.save();
                calculatedSum = null;
            }
        }
    }

    @Override
    public MessageType getType() {
        return MessageType.INTEGER;
    }

    @Override
    public String getPrefix() {
        return TYPE_PREFIX;
    }

    @Override
    public String toString() {
        Integer valueToPrint;
        if (calculatedSum != null) {
            valueToPrint = calculatedSum;
        } else {
            valueToPrint = getMessageValue();
        }
        return String.valueOf(valueToPrint);
    }

    private Integer getCalculatedSum(Message previousMessage) {
        DataMessage previousDataMessage = (DataMessage) previousMessage;
        Integer previousValue = getPreviousValue(previousDataMessage);
        isSumOverflow = isSumOverflow(previousValue, getMessageValue());

        return previousValue + getMessageValue();
    }

    private Integer getPreviousValue(DataMessage previousDataMessage) {
        if (previousDataMessage.getCalculatedValue() != null && previousDataMessage.getCalculatedValue().getType() == MessageType.INTEGER) {
            return (Integer) previousDataMessage.getCalculatedValue().getMessageValue();
        } else {
            return (Integer) previousDataMessage.getMessageValue();
        }
    }

    private boolean isSumOverflow(int a, int b) {
        long result = (long) a + b;
        return !(result == (int) result);
    }
}
